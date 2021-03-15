package br.com.casadocodigo.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.casadocodigo.entidade.Autor;

public interface AutorRepository extends JpaRepository<Autor, Long> {

}
