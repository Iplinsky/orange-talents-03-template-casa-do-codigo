package br.com.casadocodigo.entityDto;

import java.time.LocalDateTime;

import br.com.casadocodigo.entity.Autor;

public class AutorDto {

	private Long id;
	private String nome;
	private String email;
	private String descricao;
	private LocalDateTime dataCriacao;

	public Long getId() {
		return id;
	}

	public String getNome() {
		return nome;
	}

	public String getEmail() {
		return email;
	}

	public String getDescricao() {
		return descricao;
	}

	public LocalDateTime getDataCriacao() {
		return dataCriacao;
	}

	public AutorDto(Autor autor) {
		this.id = autor.getId();
		this.nome = autor.getNome();
		this.email = autor.getEmail();
		this.descricao = autor.getDescricao();
		this.dataCriacao = autor.getDataCriacao();
	}

}
