package br.com.casadocodigo.repository;

import java.util.Optional;

import javax.validation.constraints.NotBlank;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.casadocodigo.entity.Autor;

public interface AutorRepository extends JpaRepository<Autor, Long> {

	Optional<Autor> findByEmail(String email);

	Autor findByNome(@NotBlank String nomeAutor);

}
