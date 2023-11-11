package com.immunty.productservice;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.immunty.productservice.service.ProductService;

@SpringBootTest
class ProductServiceTest {

    @Autowired
    private ProductService productService;

    @Test
    void testGetAllProducts() {
        // Perform assertions based on the expected behavior of your service method
        // For example, you can check if the list is not empty
        assert !productService.getAllProducts().isEmpty();
    }

    // Add more tests for other methods in ProductService
}