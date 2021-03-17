package br.com.casadocodigo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.casadocodigo.entity.Categoria;

public interface CategoriaRepository extends JpaRepository<Categoria, Long> {

	Categoria findByNome(String nome);
}
