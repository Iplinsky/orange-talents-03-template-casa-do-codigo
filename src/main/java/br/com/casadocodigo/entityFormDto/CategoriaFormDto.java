package br.com.casadocodigo.entityFormDto;

import javax.validation.constraints.NotBlank;

import br.com.casadocodigo.entity.Categoria;
import br.com.casadocodigo.validator.UniqueValue;

public class CategoriaFormDto {

	@NotBlank(message = "O campo nome não pode estar vazio.")
	@UniqueValue(domainClass = Categoria.class, fieldName = "nome")
	private String nome;

	public Categoria converter() {
		return new Categoria(nome);
	}

	public String getNome() {
		return this.nome;
	}

}
