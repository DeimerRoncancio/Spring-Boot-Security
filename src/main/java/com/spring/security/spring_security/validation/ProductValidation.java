package com.spring.security.spring_security.validation;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
// import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.spring.security.spring_security.entities.Product;
@Component
public class ProductValidation implements Validator {

    @Override
    @SuppressWarnings("null")
    public boolean supports(Class<?> clazz) {
        return Product.class.isAssignableFrom(clazz);
    }

    @Override
    @SuppressWarnings("null")
    public void validate(Object target, Errors errors) {
        Product product = (Product) target;

        if (product.getName().isBlank()) {
            errors.rejectValue("name", null, "es requerido! (por clase personalizada)");
        } else if (product.getName().length() < 5 || product.getName().length() > 500) {
            errors.rejectValue("name", null, "debe tener un tamaño de entre 5 a 500 caracteres (por clase personalizada)");
        }
    }
}
