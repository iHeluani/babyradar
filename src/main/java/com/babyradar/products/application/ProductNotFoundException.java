package com.babyradar.products.application;

public class ProductNotFoundException extends RuntimeException {

    public ProductNotFoundException(String ean) {
        super("Product with EAN %s not found".formatted(ean));
    }
}