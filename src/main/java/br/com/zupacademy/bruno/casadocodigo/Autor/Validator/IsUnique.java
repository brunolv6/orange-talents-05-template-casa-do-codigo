package br.com.zupacademy.bruno.casadocodigo.Autor.Validator;

import static java.lang.annotation.ElementType.CONSTRUCTOR;
import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

@Target({ FIELD, CONSTRUCTOR })
@Retention(RUNTIME)
@Constraint(validatedBy = { IsUniqueValidator.class })
public @interface IsUnique {
	String message() default "Já cadastrado, deve ser único";

	Class<?>[] groups() default {};

	Class<? extends Payload>[] payload() default {};
	
	Class<?> entidade();
	
	String atributo();
}
