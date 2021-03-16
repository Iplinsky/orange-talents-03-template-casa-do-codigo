package br.com.casadocodigo.entityDto;

import br.com.casadocodigo.entity.Categoria;

public class CategoriaDto {

	private Long id;
	private String nome;

	public CategoriaDto() {
	}

	public CategoriaDto(Categoria categoria) {
		this.id = categoria.getId();
		this.nome = categoria.getNome();
	}

	public Long getId() {
		return id;
	}

	public String getNome() {
		return nome;
	}

}
