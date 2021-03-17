package br.com.casadocodigo.validator;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class CheckIdConstraint implements ConstraintValidator<CheckId, Object> {

	private String idField;
	private Class<?> domainClass;

	@PersistenceContext
	private EntityManager em;

	@Override
	public void initialize(CheckId checkIdConstraint) {
		this.idField = checkIdConstraint.idField();
		this.domainClass = checkIdConstraint.domainClass();
	}

	@Override
	public boolean isValid(Object value, ConstraintValidatorContext context) {
		String sql = "SELECT 1 FROM ".concat(domainClass.getName()).concat(" WHERE ".concat(idField)).concat(" = :value");		
		Query query = em.createQuery(sql);
		query.setParameter("value", value);

		List<?> list = query.getResultList();

		return !list.isEmpty();
	}

}
