package br.com.casadocodigo.entityFormDto;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import br.com.casadocodigo.entity.Autor;
import br.com.casadocodigo.validator.UniqueValue;

public class AutorFormDto {

	@NotBlank
	private String nome;

	@NotBlank
	@Email
	@UniqueValue(domainClass = Autor.class, fieldName = "email")
	private String email;

	@NotBlank
	@Size(max = 400, message = "A descrição deve ter no máximo 400 caracteres.")
	private String descricao;

	public void setNome(String nome) {
		this.nome = nome;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Autor converter() {
		return new Autor(nome, email, descricao);
	}

	public String getEmail() {
		return this.email;
	}

}
