package br.com.casadocodigo.validator;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = CheckIdConstraint.class)
public @interface CheckId {

	String message() default "Registro não identificado!";

	Class<?>[] groups() default {};

	Class<? extends Payload>[] payload() default {};

	String idField() default "";

	Class<?> domainClass();
}
