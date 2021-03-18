package br.com.casadocodigo.entityFormDto;

import javax.validation.constraints.NotBlank;

import br.com.casadocodigo.entity.Pais;
import br.com.casadocodigo.validator.UniqueValue;

public class PaisFormDto {

	@NotBlank
	@UniqueValue(domainClass = Pais.class, fieldName = "nome")
	private String nome;

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Pais converter() {
		return new Pais(nome);
	}

}
