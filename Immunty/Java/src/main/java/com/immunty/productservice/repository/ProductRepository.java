package com.immunty.productservice.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import com.immunty.productservice.model.Product;

public interface ProductRepository extends MongoRepository<Product, String> {
    // You can add custom query methods here if needed
}