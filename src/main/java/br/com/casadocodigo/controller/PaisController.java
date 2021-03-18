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

import br.com.casadocodigo.entity.Pais;
import br.com.casadocodigo.entityDto.PaisDto;
import br.com.casadocodigo.entityFormDto.PaisFormDto;
import br.com.casadocodigo.repository.PaisRepository;

@RestController
@RequestMapping("/paises")
public class PaisController {

	private PaisRepository paisRepository;

	public PaisController(PaisRepository paisRepository) {
		this.paisRepository = paisRepository;
	}

	@PostMapping
	@Transactional
	public ResponseEntity<PaisDto> cadastro(@RequestBody @Valid PaisFormDto form, UriComponentsBuilder uriBuilder) {
		Pais pais = form.converter();
		paisRepository.save(pais);

		URI uri = uriBuilder.path("/paises/{id}").buildAndExpand(pais.getId()).toUri();
		return ResponseEntity.created(uri).body(new PaisDto(pais));
	}

}
