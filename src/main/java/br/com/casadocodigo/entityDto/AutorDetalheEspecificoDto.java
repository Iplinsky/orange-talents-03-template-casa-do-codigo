package br.com.casadocodigo.entityDto;

import br.com.casadocodigo.entity.Autor;

public class AutorDetalheEspecificoDto {

	private String nome;
	private String descricao;

	public AutorDetalheEspecificoDto(Autor autor) {
		this.nome = autor.getNome();
		this.descricao = autor.getDescricao();
	}

	public String getNome() {
		return nome;
	}

	public String getDescricao() {
		return descricao;
	}

}
