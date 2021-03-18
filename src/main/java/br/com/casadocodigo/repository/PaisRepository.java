package br.com.casadocodigo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.casadocodigo.entity.Pais;

public interface PaisRepository extends JpaRepository<Pais, Long> {
}
