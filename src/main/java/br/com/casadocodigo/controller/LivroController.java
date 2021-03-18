package br.com.casadocodigo.controller;

import java.net.URI;
import java.util.List;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.casadocodigo.entity.Livro;
import br.com.casadocodigo.entityDto.LivroDto;
import br.com.casadocodigo.entityDto.LivroDtoSimplificado;
import br.com.casadocodigo.entityFormDto.LivroFormDto;
import br.com.casadocodigo.repository.AutorRepository;
import br.com.casadocodigo.repository.CategoriaRepository;
import br.com.casadocodigo.repository.LivroRepository;

@RestController
@RequestMapping("/livros")
public class LivroController {

	private LivroRepository livroRepository;
	private CategoriaRepository categoriaRepository;
	private AutorRepository autorRepository;

	public LivroController(LivroRepository livroRepository, CategoriaRepository categoriaRepository,
			AutorRepository autorRepository) {
		this.livroRepository = livroRepository;
		this.categoriaRepository = categoriaRepository;
		this.autorRepository = autorRepository;
	}

	@PostMapping
	@Transactional
	public ResponseEntity<LivroDto> cadastro(@RequestBody @Valid LivroFormDto form, UriComponentsBuilder uriBuilder) {
		Livro livro = form.converter(categoriaRepository, autorRepository);
		livroRepository.save(livro);

		URI uri = uriBuilder.path("/livros/{id}").buildAndExpand(livro.getId()).toUri();
		return ResponseEntity.created(uri).body(new LivroDto(livro));
	}

	@GetMapping
	public List<LivroDtoSimplificado> recuperarRegistros() {
		List<Livro> listaDeLivros = livroRepository.findAll();
		return LivroDtoSimplificado.converter(listaDeLivros);
	}
}
