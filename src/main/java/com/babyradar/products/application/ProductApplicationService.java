package com.babyradar.products.application;

import com.babyradar.products.domain.Product;
import com.babyradar.products.domain.ProductOffer;
import com.babyradar.products.domain.ProductOfferRepository;
import com.babyradar.products.domain.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductApplicationService {

    private final ProductRepository productRepository;
    private final ProductOfferRepository productOfferRepository;

    // ======== PRODUCTOS =========

    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    public Product getProductById(Long id) {
        return productRepository.findById(id)
                .orElseThrow(() -> new ProductNotFoundException("id= " + id));
    }

    public Product getProductByEan(String ean) {
        return productRepository.findByEan(ean)
                .orElseThrow(() -> new ProductNotFoundException("ean= " + ean));
    }

    public List<Product> getProductsByBrand(String brand) {
        return productRepository.findByBrand(brand);
    }

    public Product saveProduct(Product product) {
        return productRepository.save(product);
    }

    // ======== OFERTAS =========

    public List<ProductOffer> getOffersForProductEan(String ean) {
        Product product = getProductByEan(ean);
        return productOfferRepository.findByProduct(product);
    }

    public ProductOffer saveOffer(ProductOffer offer) {
        return productOfferRepository.save(offer);
    }
}