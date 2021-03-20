package br.com.casadocodigo.entityDto;

import br.com.casadocodigo.entity.Cliente;

public class ClienteDto {

	private Long id;

	public ClienteDto(Cliente cliente) {
		this.id = cliente.getId();
	}

	public Long getId() {
		return id;
	}
}
