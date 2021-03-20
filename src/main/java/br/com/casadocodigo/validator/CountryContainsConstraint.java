package br.com.casadocodigo.validator;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import br.com.casadocodigo.entity.Estado;
import br.com.casadocodigo.entity.Pais;
import br.com.casadocodigo.entityFormDto.ClienteFormDto;

public class CountryContainsConstraint implements ConstraintValidator<CountryContains, ClienteFormDto> {

	@PersistenceContext
	private EntityManager em;

	@Override
	public boolean isValid(ClienteFormDto cliente, ConstraintValidatorContext context) {

		Estado estado = cliente.getCodEstado() != null ? em.find(Estado.class, cliente.getCodEstado()) : null;
		Pais pais = em.find(Pais.class, cliente.getCodPais());
		boolean check = true;

		if (pais.getEstado().size() > 0) {
			for (Estado e : pais.getEstado()) {
				check = e.getId() == estado.getId() ? true : false;
			}
		}

		if ((pais.getEstado().size() > 0 && cliente.getCodEstado() == null)
				|| (pais.getEstado().size() == 0 && cliente.getCodEstado() != null)) {
			return false;
		} else if (check && pais.getEstado().size() == 0 && cliente.getCodEstado() == null) {
			return true;
		}

		return true;
	}

}