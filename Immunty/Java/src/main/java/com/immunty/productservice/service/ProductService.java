package com.immunty.productservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.immunty.productservice.model.Product;
import com.immunty.productservice.repository.ProductRepository;
import java.util.List;

@Service
public class ProductService {

    private final ProductRepository productRepository;

    @Autowired
    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    public Product getProductById(String productId) {
        return productRepository.findById(productId).orElse(null);
    }

    public Product createProduct(Product product) {
        // Additional validation logic can be added here
        return productRepository.save(product);
    }

    public Product updateProduct(String productId, Product updatedProduct) {
        Product existingProduct = productRepository.findById(productId).orElse(null);
        if (existingProduct != null) {
            // Update properties based on your requirements
            existingProduct.setProductName(updatedProduct.getProductName());
            existingProduct.setProductDescription(updatedProduct.getProductDescription());
            existingProduct.setPrice(updatedProduct.getPrice());
            existingProduct.setAvailabilityStatus(updatedProduct.getAvailabilityStatus());

            return productRepository.save(existingProduct);
        } else {
            return null;
        }
    }

    public boolean deleteProduct(String productId) {
        if (productRepository.existsById(productId)) {
            productRepository.deleteById(productId);
            return true;
        } else {
            return false;
        }
    }
}
