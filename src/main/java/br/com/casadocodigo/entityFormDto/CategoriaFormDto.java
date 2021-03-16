package br.com.casadocodigo.entityFormDto;

import javax.validation.constraints.NotBlank;

import br.com.casadocodigo.entity.Categoria;

public class CategoriaFormDto {

	@NotBlank(message = "O campo nome não pode estar vazio.")
	private String nome;

	public Categoria converter() {
		return new Categoria(nome);
	}

	public String getNome() {
		return this.nome;
	}

}
