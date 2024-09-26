package com.spring.security.spring_security.repositories;

import org.springframework.data.repository.CrudRepository;
import com.spring.security.spring_security.entities.Product;

public interface ProductRepository extends CrudRepository<Product, Long> {
    
    boolean existsBySku(String sku);
}
