package com.spring.security.spring_security.validation;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.annotation.ElementType;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

@Constraint(validatedBy = IsRequiredValidation.class)
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.FIELD, ElementType.METHOD})
public @interface IsRequired {

    String message() default "es requerido!";
    
    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
