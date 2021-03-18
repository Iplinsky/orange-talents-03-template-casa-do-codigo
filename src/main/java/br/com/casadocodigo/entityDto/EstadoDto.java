package br.com.casadocodigo.entityDto;

import br.com.casadocodigo.entity.Estado;

public class EstadoDto {

	private String nome;

	public EstadoDto(Estado estado) {
		this.nome = estado.getNome();
	}

	public String getNome() {
		return nome;
	}

}
