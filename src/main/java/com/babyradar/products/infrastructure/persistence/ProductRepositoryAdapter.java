package com.babyradar.products.infrastructure.persistence;

import com.babyradar.products.domain.Product;
import com.babyradar.products.domain.ProductCategory;
import com.babyradar.products.domain.ProductRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class ProductRepositoryAdapter implements ProductRepository {

    private final SpringDataProductJpaRepository jpa;

    public ProductRepositoryAdapter(SpringDataProductJpaRepository jpa) {
        this.jpa = jpa;
    }

    @Override
    public Optional<Product> findById(Long id) {
        return jpa.findById(id).map(ProductMapper::toDomain);
    }

    @Override
    public Optional<Product> findByEan(String ean) {
        return jpa.findByEan(ean).map(ProductMapper::toDomain);
    }

    @Override
    public List<Product> findByBrand(String brand) {
        return jpa.findByBrandIgnoreCase(brand).stream()
                .map(ProductMapper::toDomain)
                .toList();
    }

    @Override
    public List<Product> findByCategory(ProductCategory category) {
        return jpa.findByCategory(category).stream()
                .map(ProductMapper::toDomain)
                .toList();
    }

    @Override
    public List<Product> findByNameContains(String namePart) {
        return jpa.findByNameContainingIgnoreCase(namePart).stream()
                .map(ProductMapper::toDomain)
                .toList();
    }

    @Override
    public List<Product> findAll() {
        return jpa.findAll().stream()
                .map(ProductMapper::toDomain)
                .toList();
    }

    @Override
    public Product save(Product product) {
        ProductEntity entity = ProductMapper.toEntity(product);
        ProductEntity saved = jpa.save(entity);
        return ProductMapper.toDomain(saved);
    }

    @Override
    public void deleteById(Long id) {
        jpa.deleteById(id);
    }
}