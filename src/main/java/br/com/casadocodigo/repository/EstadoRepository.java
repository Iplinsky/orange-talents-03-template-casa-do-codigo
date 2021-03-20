package br.com.casadocodigo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.casadocodigo.entity.Estado;
import br.com.casadocodigo.entity.Pais;

public interface EstadoRepository extends JpaRepository<Estado, Long> {

	List<Estado> findByPais(Pais pais);
}
