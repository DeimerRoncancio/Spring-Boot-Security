package com.spring.security.spring_security.validation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.spring.security.spring_security.services.ProductService;

@Component
public class IsExistDbValidation implements ConstraintValidator<IsExistDb, String> {

    @Autowired
    private ProductService service;
    
    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        if (service == null) {
            return true;
        } else {
            return !service.existsBySku(value);
        }
    }
}
