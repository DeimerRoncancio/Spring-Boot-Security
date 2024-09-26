package com.spring.security.spring_security.validation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import java.lang.annotation.Target;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Constraint(validatedBy = IsExistDbValidation.class)
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface IsExistDb {

    String message() default "tiene el valor de un producto ya existente en la bd";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
