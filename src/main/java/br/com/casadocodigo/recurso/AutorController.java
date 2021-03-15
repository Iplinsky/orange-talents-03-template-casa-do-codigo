package br.com.casadocodigo.recurso;

import java.net.URI;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.casadocodigo.entidade.Autor;
import br.com.casadocodigo.entidadeDto.AutorDto;
import br.com.casadocodigo.entidadeFormDto.AutorFormDto;
import br.com.casadocodigo.repositorio.AutorRepository;

@RestController
@RequestMapping("/autor")
public class AutorController {

	@Autowired
	private AutorRepository autorRepository;

	@PostMapping
	@Transactional
	public ResponseEntity<AutorDto> cadastro(@RequestBody @Valid AutorFormDto autorFormDto,
			UriComponentsBuilder uriBuilder) {
		Autor autor = autorFormDto.converter();
		autorRepository.save(autor);

		URI uri = uriBuilder.path("/autor/{id}").buildAndExpand(autor.getId()).toUri();
		return ResponseEntity.created(uri).body(new AutorDto(autor));
	}
}