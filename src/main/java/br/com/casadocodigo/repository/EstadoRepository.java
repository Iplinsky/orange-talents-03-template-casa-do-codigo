package br.com.casadocodigo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.casadocodigo.entity.Estado;

public interface EstadoRepository extends JpaRepository<Estado, Long> {
}
