package br.com.casadocodigo.controller;

import java.net.URI;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.casadocodigo.entity.Categoria;
import br.com.casadocodigo.entityDto.CategoriaDto;
import br.com.casadocodigo.entityFormDto.CategoriaFormDto;
import br.com.casadocodigo.repository.CategoriaRepository;
import br.com.casadocodigo.validator.BloqueiaNomeCategoriaDuplicadoValidator;

@RestController
@RequestMapping("/categorias")
public class CategoriaController {

	private CategoriaRepository repository;

	public CategoriaController(CategoriaRepository categoriaRepository) {
		this.repository = categoriaRepository;
	}

	private BloqueiaNomeCategoriaDuplicadoValidator bloqueiaNomeCategoriaDuplicadoValidator;

	@InitBinder
	public void initBinder(WebDataBinder dataBinder) {
		dataBinder.addValidators(bloqueiaNomeCategoriaDuplicadoValidator);
	}

	@PostMapping
	@Transactional
	public ResponseEntity<CategoriaDto> cadastro(@RequestBody @Valid CategoriaFormDto categoriaFormDto,
			UriComponentsBuilder uriBuilder) {
		Categoria categoria = categoriaFormDto.converter();
		repository.save(categoria);

		URI uri = uriBuilder.path("/categorias/{id}").buildAndExpand(categoria.getId()).toUri();
		return ResponseEntity.created(uri).body(new CategoriaDto(categoria));
	}

}
