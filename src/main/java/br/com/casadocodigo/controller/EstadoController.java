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

import br.com.casadocodigo.entity.Estado;
import br.com.casadocodigo.entityDto.EstadoDto;
import br.com.casadocodigo.entityFormDto.EstadoFormDto;
import br.com.casadocodigo.repository.EstadoRepository;
import br.com.casadocodigo.repository.PaisRepository;

@RestController
@RequestMapping("/estados")
public class EstadoController {

	private EstadoRepository estadoRepository;
	private PaisRepository paisRepository;

	public EstadoController(EstadoRepository estadoRepository, PaisRepository paisRepository) {
		this.estadoRepository = estadoRepository;
		this.paisRepository = paisRepository;
	}

	@PostMapping
	@Transactional
	public ResponseEntity<EstadoDto> cadastro(@RequestBody @Valid EstadoFormDto form, UriComponentsBuilder uriBuilder) {
		Estado estado = form.converter(paisRepository);
		estadoRepository.save(estado);
		URI uri = uriBuilder.path("/estados/{id}").buildAndExpand(estado.getId()).toUri();

		return ResponseEntity.created(uri).body(new EstadoDto(estado));
	}

}
