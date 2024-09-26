package com.spring.security.spring_security.validation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class IsRequiredValidation implements ConstraintValidator<IsRequired, String> {

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        return (value != null && !value.isBlank());
    }
}
