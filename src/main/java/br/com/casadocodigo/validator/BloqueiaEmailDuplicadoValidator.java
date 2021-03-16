package br.com.casadocodigo.validator;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import br.com.casadocodigo.entity.Autor;
import br.com.casadocodigo.entityFormDto.AutorFormDto;
import br.com.casadocodigo.repository.AutorRepository;

@Component
public class BloqueiaEmailDuplicadoValidator implements Validator {

	@Autowired
	AutorRepository repository;

	@Override // Indica onde será aplicada a validação
	public boolean supports(Class<?> clazz) {
		return AutorFormDto.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		if (errors.hasErrors()) {
			return;
		}

		AutorFormDto form = (AutorFormDto) target;
		Optional<Autor> autor = repository.findByEmail(form.getEmail());

		if (autor.isPresent()) {
			errors.reject("email", null, "Já existe um(a) autor(a) com o e-mail informado!");
		}
	}

}
