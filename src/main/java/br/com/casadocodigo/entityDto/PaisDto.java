package br.com.casadocodigo.entityDto;

import br.com.casadocodigo.entity.Pais;

public class PaisDto {

	private Long id;
	private String nome;

	public Long getId() {
		return this.id;
	}

	public String getNome() {
		return nome;
	}

	public PaisDto(Pais pais) {
		this.id = pais.getId();
		this.nome = pais.getNome();
	}

}
