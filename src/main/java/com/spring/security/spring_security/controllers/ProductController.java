package com.spring.security.spring_security.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import com.spring.security.spring_security.entities.Product;
import com.spring.security.spring_security.services.ProductService;
import com.spring.security.spring_security.validation.ProductValidation;

import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;

@RestController
@RequestMapping("/api/security")
public class ProductController {

    @Autowired
    private ProductService service;

    @Autowired
    private ProductValidation validation;
    
    @GetMapping
    public List<Product> viewAll() {
        return service.viewAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Product> view(@PathVariable Long id) {
        Optional<Product> product = service.view(id);

        if(product.isPresent())
            return ResponseEntity.ok().body(product.get());
        
        return ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<?> create(@Valid @RequestBody Product product, BindingResult result) {
        validation.validate(product, result);

        if (result.hasFieldErrors())
            return validate(result);
        return ResponseEntity.status(HttpStatus.CREATED).body(service.create(product));
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@Valid @RequestBody Product product, @PathVariable Long id, BindingResult result) {
        Optional<Product> productDb = service.update(id, product);

        validation.validate(product, result);
        if (result.hasFieldErrors())
            return validate(result);
        
        if (productDb.isPresent())
            return ResponseEntity.status(HttpStatus.CREATED).body(productDb.get());
        
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        Optional<Product> productDb = service.delete(id);

        if (productDb.isPresent())
            return ResponseEntity.ok(productDb.orElseThrow());
        
        return ResponseEntity.notFound().build();
    }

    public ResponseEntity<?> validate(BindingResult result) {
        Map<String, String> errors = new HashMap<> ();

        result.getFieldErrors().forEach(err -> {
            errors.put(err.getField(), "El campo " + err.getField() + " " + err.getDefaultMessage());
        });

        return ResponseEntity.badRequest().body(errors);
    }
}
