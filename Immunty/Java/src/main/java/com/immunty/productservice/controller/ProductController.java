package com.immunty.productservice.controller;

import java.util.List;
import org.springframework.web.bind.annotation.RestController;

import com.immunty.productservice.model.Product;
import com.immunty.productservice.service.ProductService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/products")
public class ProductController {

    private final ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping
    public ResponseEntity<List<Product>> getAllProducts() {
        List<Product> products = productService.getAllProducts();
        return ResponseEntity.ok(products);
    }

    @GetMapping("/{product_id}")
    public ResponseEntity<Product> getProductById(@PathVariable("product_id") String productId) {
        Product product = productService.getProductById(productId);
        if (product != null) {
            return ResponseEntity.ok(product);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity<Product> createProduct(@RequestBody Product product) {
        Product createdProduct = productService.createProduct(product);
        return ResponseEntity.ok(createdProduct);
    }

    @PutMapping("/{product_id}")
    public ResponseEntity<Product> updateProduct(
            @PathVariable("product_id") String productId,
            @RequestBody Product updatedProduct
    ) {
        Product product = productService.updateProduct(productId, updatedProduct);
        if (product != null) {
            return ResponseEntity.ok(product);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{product_id}")
    public ResponseEntity<Void> deleteProduct(@PathVariable("product_id") String productId) {
        boolean deleted = productService.deleteProduct(productId);
        if (deleted) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}

