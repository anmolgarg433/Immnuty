package com.immunty.productservice.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "products")
public class Product {

    @Id
    private String id;

    private String productName;
    private String productDescription;
    private double price;
    private boolean availabilityStatus;

    // Constructors, getters, and setters

    public Product() {
        // Default constructor
    }

    public Product(String productName, String productDescription, double price, boolean availabilityStatus) {
        this.productName = productName;
        this.productDescription = productDescription;
        this.price = price;
        this.availabilityStatus = availabilityStatus;
    }

    // Getters and setters

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductDescription() {
        return productDescription;
    }

    public Boolean getAvailabilityStatus() {
        return availabilityStatus;
    }

    public void setProductDescription(String productDescription) {
        this.productDescription = productDescription;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public boolean isAvailabilityStatus() {
        return availabilityStatus;
    }

    public void setAvailabilityStatus(boolean availabilityStatus) {
        this.availabilityStatus = availabilityStatus;
    }

    // toString method (for logging and debugging)

    @Override
    public String toString() {
        return "Product{" +
                "id='" + id + '\'' +
                ", productName='" + productName + '\'' +
                ", productDescription='" + productDescription + '\'' +
                ", price=" + price +
                ", availabilityStatus=" + availabilityStatus +
                '}';
    }
}
