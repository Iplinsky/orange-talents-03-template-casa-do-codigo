package br.com.casadocodigo.validator;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.util.Assert;

public class UniqueValueConstraint implements ConstraintValidator<UniqueValue, Object> {

	private String fieldName;
	private Class<?> domainClass;

	@PersistenceContext
	private EntityManager em;

	@Override
	public void initialize(UniqueValue uniqueValueConstraint) {
		this.fieldName = uniqueValueConstraint.fieldName();
		this.domainClass = uniqueValueConstraint.domainClass();
	}

	@Override
	public boolean isValid(Object value, ConstraintValidatorContext context) {
		String sql = "SELECT 1 from ".concat(domainClass.getName()).concat(" WHERE ".concat(fieldName)).concat(" = :value");
		Query query = em.createQuery(sql);
		query.setParameter("value", value);

		List<?> list = query.getResultList();

		Assert.state(list.size() <= 1,
				"Já existe um ".concat(domainClass.getName()).concat(" com o atributo ").concat(fieldName));

		return list.isEmpty();
	}
}
