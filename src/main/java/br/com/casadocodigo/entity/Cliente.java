package br.com.casadocodigo.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
public class Cliente {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotBlank
	@Email
	private String email;

	@NotBlank
	private String nome;

	@NotBlank
	private String sobrenome;

	@NotBlank
	private String cpf_cnpj;

	@NotBlank
	private String endereco;

	@NotBlank
	private String complemento;

	@NotBlank
	private String cidade;

	@NotNull
	@ManyToOne
	@JoinColumn(name = "pais_id", nullable = false)
	private Pais paisCliente;

	@ManyToOne
	@JoinColumn(name = "estado_id")
	private Estado estadoCliente;

	@NotBlank
	private String telefone;

	@NotBlank
	private String cep;

	@Deprecated
	public Cliente() {
	}

	public Cliente(@NotBlank @Email String email, @NotBlank String nome, @NotBlank String sobrenome,
			@NotBlank String cpf_cnpj, @NotBlank String endereco, @NotBlank String complemento, @NotBlank String cidade,
			@NotNull Pais paisCliente, Estado estadoCliente, @NotBlank String telefone, @NotBlank String cep) {
		this.email = email;
		this.nome = nome;
		this.sobrenome = sobrenome;
		this.cpf_cnpj = cpf_cnpj;
		this.endereco = endereco;
		this.complemento = complemento;
		this.cidade = cidade;
		this.paisCliente = paisCliente;
		this.estadoCliente = estadoCliente;
		this.telefone = telefone;
		this.cep = cep;
	}

	public Long getId() {
		return id;
	}

	public String getNome() {
		return nome;
	}

}
