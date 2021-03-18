package br.com.casadocodigo.entityDto;

import java.time.format.DateTimeFormatter;

import br.com.casadocodigo.entity.Livro;

public class LivroDetalhadoDto {

	private Long id;
	private String titulo;
	private String resumo;
	private String sumario;
	private Double preco;
	private Long numeroDePaginas;
	private String isbn;
	private AutorDetalheEspecificoDto autorDetalheEspecificoDto;
	private String dataPublicacao;

	public LivroDetalhadoDto(Livro livro) {
		this.id = livro.getId();
		this.titulo = livro.getTitulo();
		this.resumo = livro.getResumo();
		this.sumario = livro.getSumario();
		this.preco = livro.getPreco();
		this.numeroDePaginas = livro.getNumeroDePaginas();
		this.isbn = livro.getIsbn();
		this.autorDetalheEspecificoDto = new AutorDetalheEspecificoDto(livro.getAutor());
		this.dataPublicacao = livro.getDataPublicacao().format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
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

	public AutorDetalheEspecificoDto getAutorDetalheEspecificoDto() {
		return autorDetalheEspecificoDto;
	}

	public String getDataPublicacao() {
		return dataPublicacao;
	}
}
