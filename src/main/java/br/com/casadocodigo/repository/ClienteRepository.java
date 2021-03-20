package br.com.casadocodigo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.casadocodigo.entity.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {
}
