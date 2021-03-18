package br.com.casadocodigo.entityFormDto;

import java.util.Optional;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import br.com.casadocodigo.entity.Estado;
import br.com.casadocodigo.entity.Pais;
import br.com.casadocodigo.repository.PaisRepository;
import br.com.casadocodigo.validator.CheckId;
import br.com.casadocodigo.validator.UniqueValue;

public class EstadoFormDto {

	@NotBlank
	@UniqueValue(domainClass = Estado.class, fieldName = "nome")
	private String nome;

	@NotNull
	@CheckId(domainClass = Pais.class, idField = "id")
	private Long idCodPais;

	public EstadoFormDto(@NotBlank String nome, @NotNull Long idCodPais) {
		this.nome = nome;
		this.idCodPais = idCodPais;
	}

	public Estado converter(PaisRepository paisRepository) {
		Optional<Pais> pais = paisRepository.findById(idCodPais);
		return new Estado(nome, pais.get());
	}

}
