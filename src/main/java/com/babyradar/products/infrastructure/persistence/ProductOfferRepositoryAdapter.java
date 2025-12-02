package com.babyradar.products.infrastructure.persistence;

import com.babyradar.products.domain.Product;
import com.babyradar.products.domain.ProductOffer;
import com.babyradar.products.domain.ProductOfferRepository;
import com.babyradar.products.domain.ProductRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class ProductOfferRepositoryAdapter implements ProductOfferRepository {

    private final SpringDataProductOfferJpaRepository jpa;
    private final SpringDataProductJpaRepository productJpa;
    private final ProductRepository productRepository; // por si quieres reutilizarlo

    public ProductOfferRepositoryAdapter(SpringDataProductOfferJpaRepository jpa,
                                         SpringDataProductJpaRepository productJpa,
                                         ProductRepository productRepository) {
        this.jpa = jpa;
        this.productJpa = productJpa;
        this.productRepository = productRepository;
    }

    @Override
    public Optional<ProductOffer> findById(Long id) {
        return jpa.findById(id).map(ProductOfferMapper::toDomain);
    }

    @Override
    public List<ProductOffer> findByProduct(Product product) {
        ProductEntity entity = ProductMapper.toEntity(product);
        return jpa.findByProduct(entity).stream()
                .map(ProductOfferMapper::toDomain)
                .toList();
    }

    @Override
    public List<ProductOffer> findByProductEan(String ean) {
        return jpa.findByProduct_Ean(ean).stream()
                .map(ProductOfferMapper::toDomain)
                .toList();
    }

    @Override
    public List<ProductOffer> findByShopName(String shopName) {
        return jpa.findByShopNameIgnoreCase(shopName).stream()
                .map(ProductOfferMapper::toDomain)
                .toList();
    }

    @Override
    public List<ProductOffer> findByProductId(Long id) {
        return jpa.findByProduct_Id(id).stream()
                .map(ProductOfferMapper::toDomain)
                .toList();
    }

    @Override
    public ProductOffer save(ProductOffer offer) {
        // Mapeamos el producto del offer a ProductEntity
        ProductEntity productEntity = null;
        if (offer.getProduct() != null) {
            productEntity = ProductMapper.toEntity(offer.getProduct());
            // Si quieres asegurarte de que existe:
            productEntity = productJpa.save(productEntity);
        }

        ProductOfferEntity entity = ProductOfferMapper.toEntity(offer, productEntity);
        ProductOfferEntity saved = jpa.save(entity);
        return ProductOfferMapper.toDomain(saved);
    }

    @Override
    public void deleteById(Long id) {
        jpa.deleteById(id);
    }
}