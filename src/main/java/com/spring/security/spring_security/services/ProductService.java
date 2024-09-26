package com.spring.security.spring_security.services;

import com.spring.security.spring_security.entities.Product;
import java.util.List;
import java.util.Optional;

public interface ProductService {

    List<Product> viewAll();

    Optional<Product> view(Long id);

    Product create(Product product);

    Optional<Product> update(Long id, Product product);

    Optional<Product> delete(Long id);

    boolean existsBySku(String sku);
}
