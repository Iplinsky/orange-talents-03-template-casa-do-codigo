package br.com.casadocodigo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.casadocodigo.entity.Livro;

public interface LivroRepository extends JpaRepository<Livro, Long> {
}
