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

import br.com.casadocodigo.entity.Cliente;
import br.com.casadocodigo.entityDto.ClienteDto;
import br.com.casadocodigo.entityFormDto.ClienteFormDto;
import br.com.casadocodigo.repository.ClienteRepository;
import br.com.casadocodigo.repository.EstadoRepository;
import br.com.casadocodigo.repository.PaisRepository;

@RestController
@RequestMapping("/clientes")
public class ClienteController {

	private PaisRepository paisRepository;
	private EstadoRepository estadoRepository;
	private ClienteRepository clienteRepository;

	public ClienteController(PaisRepository paisRepository, EstadoRepository estadoRepository,
			ClienteRepository clienteRepository) {
		this.paisRepository = paisRepository;
		this.estadoRepository = estadoRepository;
		this.clienteRepository = clienteRepository;
	}

	@PostMapping
	@Transactional
	public ResponseEntity<ClienteDto> cadastro(@RequestBody @Valid ClienteFormDto clienteFormDto,
			UriComponentsBuilder uriBuilder) {
		Cliente cliente = clienteFormDto.converter(paisRepository, estadoRepository);
		clienteRepository.save(cliente);

		URI uri = uriBuilder.path("/clientes/{id}").buildAndExpand(cliente.getId()).toUri();
		return ResponseEntity.created(uri).body(new ClienteDto(cliente));
	}

}
