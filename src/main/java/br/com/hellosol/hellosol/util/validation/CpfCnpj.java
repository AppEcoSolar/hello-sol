package br.com.hellosol.hellosol.util.validation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Documented
@Constraint(validatedBy = CpfCnpjValidator.class)
@Target({ FIELD })
@Retention(RUNTIME)
public @interface CpfCnpj {

    String message() default "O CPF ou CNPJ é inválido.";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}

