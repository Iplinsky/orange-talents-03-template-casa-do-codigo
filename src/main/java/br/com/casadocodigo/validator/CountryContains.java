package br.com.casadocodigo.validator;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = CountryContainsConstraint.class)
public @interface CountryContains {

	String message() default "Erro de relação entre País e Estado!";

	Class<?>[] groups() default {};

	Class<? extends Payload>[] payload() default {};
}
