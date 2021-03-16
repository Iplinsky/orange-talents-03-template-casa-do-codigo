package br.com.casadocodigo.controller;

import java.net.URI;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.casadocodigo.entity.Autor;
import br.com.casadocodigo.entityDto.AutorDto;
import br.com.casadocodigo.entityFormDto.AutorFormDto;
import br.com.casadocodigo.repository.AutorRepository;

@RestController
@RequestMapping("/autores")
public class AutorController {

	private final AutorRepository repository;

	public AutorController(AutorRepository autorRepository) {
		this.repository = autorRepository;
	}

	@PostMapping
	@Transactional
	public ResponseEntity<AutorDto> cadastro(@RequestBody @Valid AutorFormDto autorFormDto,
			UriComponentsBuilder uriBuilder) {
		Autor autor = autorFormDto.converter();
		repository.save(autor);

		URI uri = uriBuilder.path("/autor/{id}").buildAndExpand(autor.getId()).toUri();
		return ResponseEntity.created(uri).body(new AutorDto(autor));
	}
}