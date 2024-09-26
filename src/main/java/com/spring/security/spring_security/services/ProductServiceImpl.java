package com.spring.security.spring_security.services;

import com.spring.security.spring_security.entities.Product;
import com.spring.security.spring_security.repositories.ProductRepository;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.Optional;
import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository repository;

    @Override
    @Transactional(readOnly = true)
    public List<Product> viewAll() {
        return (List<Product>) repository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<Product> view(Long id) {
        return repository.findById(id);
    }

    @Override
    @Transactional
    public Product create(Product product) {
        return repository.save(product);
    }

    @Override
    @Transactional
    public Optional<Product> update(Long id, Product product) {
        Optional<Product> productOptional = repository.findById(id);
        
        productOptional.ifPresent(productDb -> {
            productDb.setName(product.getName());
            productDb.setPrice(product.getPrice());
            productDb.setDescription(product.getDescription());
            productDb.setSku(product.getSku());

            repository.save(productDb);
        });
        
        return productOptional;
    }

    @Override
    @Transactional
    public Optional<Product> delete(Long id) {
        Optional<Product> productDb = repository.findById(id);
        
        productDb.ifPresent(product -> {
            repository.delete(product);
        });
        
        return productDb;
    }

    @Override
    @Transactional(readOnly = true)
    public boolean existsBySku(String sku) {
        return repository.existsBySku(sku);
    }
}
