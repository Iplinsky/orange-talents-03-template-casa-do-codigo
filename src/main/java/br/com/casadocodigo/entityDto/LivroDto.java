package br.com.casadocodigo.entityDto;

import java.time.LocalDate;

import br.com.casadocodigo.entity.Livro;

public class LivroDto {

	private Long id;
	private String titulo;
	private String resumo;
	private String sumario;
	private Double preco;
	private Long numeroDePaginas;
	private String isbn;
	private LocalDate dataPublicacao;

	public LivroDto(Livro livro) {
		this.id = livro.getId();
		this.titulo = livro.getTitulo();
		this.resumo = livro.getResumo();
		this.sumario = livro.getSumario();
		this.preco = livro.getPreco();
		this.numeroDePaginas = livro.getNumeroDePaginas();
		this.isbn = livro.getIsbn();
		this.dataPublicacao = livro.getDataPublicacao();
	}

	public Long getId() {
		return id;
	}

	public String getTitulo() {
		return titulo;
	}

	public String getResumo() {
		return resumo;
	}

	public String getSumario() {
		return sumario;
	}

	public Double getPreco() {
		return preco;
	}

	public Long getNumeroDePaginas() {
		return numeroDePaginas;
	}

	public String getIsbn() {
		return isbn;
	}

	public LocalDate getDataPublicacao() {
		return dataPublicacao;
	}

}
