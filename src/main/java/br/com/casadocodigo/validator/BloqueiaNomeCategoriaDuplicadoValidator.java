package br.com.casadocodigo.validator;

import java.util.Optional;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import br.com.casadocodigo.entity.Categoria;
import br.com.casadocodigo.entityFormDto.CategoriaFormDto;
import br.com.casadocodigo.repository.CategoriaRepository;

@Component
public class BloqueiaNomeCategoriaDuplicadoValidator implements Validator {

	private final CategoriaRepository repository;

	public BloqueiaNomeCategoriaDuplicadoValidator(CategoriaRepository categoriaRepository) {
		this.repository = categoriaRepository;
	}

	@Override
	public boolean supports(Class<?> clazz) {
		return CategoriaFormDto.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		if (errors.hasErrors()) {
			return;
		}

		CategoriaFormDto formTarget = (CategoriaFormDto) target;
		Optional<Categoria> categoria = repository.findByNome(formTarget.getNome());

		if (categoria.isPresent()) {
			errors.rejectValue("nome", null, "Já existe uma categoria com o nome informado!");
		}

	}

}
