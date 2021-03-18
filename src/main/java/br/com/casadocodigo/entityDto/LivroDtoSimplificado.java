package br.com.casadocodigo.entityDto;

import java.util.ArrayList;
import java.util.List;

import br.com.casadocodigo.entity.Livro;

public class LivroDtoSimplificado {

	private Long id;
	private String titulo;

	public LivroDtoSimplificado(Long id, String titulo) {
		this.id = id;
		this.titulo = titulo;
	}

	public Long getId() {
		return id;
	}

	public String getTitulo() {
		return titulo;
	}

	public static List<LivroDtoSimplificado> converter(List<Livro> livros) {
		List<LivroDtoSimplificado> listaFinal = new ArrayList<LivroDtoSimplificado>();
		livros.forEach(livro -> {
			LivroDtoSimplificado dtoSimplificado = new LivroDtoSimplificado(livro.getId(), livro.getTitulo());
			listaFinal.add(dtoSimplificado);
		});
		return listaFinal;
	}

}
