package br.com.casadocodigo.entityFormDto;

import java.time.LocalDate;

import javax.validation.constraints.Future;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.util.Assert;

import com.fasterxml.jackson.annotation.JsonFormat;

import br.com.casadocodigo.entity.Autor;
import br.com.casadocodigo.entity.Categoria;
import br.com.casadocodigo.entity.Livro;
import br.com.casadocodigo.repository.AutorRepository;
import br.com.casadocodigo.repository.CategoriaRepository;
import br.com.casadocodigo.validator.CheckId;
import br.com.casadocodigo.validator.UniqueValue;

public class LivroFormDto {

	@NotBlank
	@UniqueValue(domainClass = Livro.class, fieldName = "titulo")
	private String titulo;

	@NotBlank
	@Size(max = 500)
	private String resumo;

	private String sumario;

	@NotNull
	@Min(value = 20)
	private Double preco;

	@NotNull	
	@Min(value = 100)
	private Long numeroDePaginas;

	@NotBlank
	@UniqueValue(domainClass = Livro.class, fieldName = "isbn")
	private String isbn;

	@NotNull
	@Future
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
	private LocalDate dataPublicacao;

	@NotNull
	@CheckId(domainClass = Categoria.class, idField = "id")
	private Long idCategoria;

	@NotNull
	@CheckId(domainClass = Autor.class, idField = "id")
	private Long idAutor;

	public LivroFormDto(@NotBlank String titulo, @NotBlank @Size(max = 500) String resumo, String sumario,
			@NotNull @Min(20) Double preco, @NotNull @Min(100) Long numeroDePaginas, @NotBlank String isbn,
			@NotNull Long idCategoria, @NotNull Long idAutor) {
		super();
		this.titulo = titulo;
		this.resumo = resumo;
		this.sumario = sumario;
		this.preco = preco;
		this.numeroDePaginas = numeroDePaginas;
		this.isbn = isbn;
		this.idCategoria = idCategoria;
		this.idAutor = idAutor;
	}

	/*
	 * Método setter criado para definir o valor do atributo dataPublicacao, 
	 * pois através do construtor é gerado uma falha.
	 */
	public void setDataPublicacao(LocalDate dataPublicacao) {
		this.dataPublicacao = dataPublicacao;
	}

	public Livro converter(CategoriaRepository categoriaRepository, AutorRepository autorRepository) {
		@NotNull
		Categoria categoria = categoriaRepository.getOne(idCategoria);
		@NotNull
		Autor autor = autorRepository.getOne(idAutor);		

		return new Livro(titulo, resumo, sumario, preco, numeroDePaginas, isbn, dataPublicacao, categoria, autor);
	}
}
