package com.babyradar.products.infrastucture.persitence;

import com.babyradar.products.domain.Product;
import com.babyradar.products.infrastructure.persistence.ProductRepositoryAdapter;
import com.babyradar.products.infrastructure.persistence.SpringDataProductJpaRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class ProductRepositoryAdapterIT {

    @Autowired
    private SpringDataProductJpaRepository jpa;

    @Autowired
    private ProductRepositoryAdapter adapter;

    @Test
    void save_and_findByEan_work() {
        Product product = Product.builder()
                .ean("406230345593")
                .name("Multicereales sin azúcares añadidos Hipp")
                .brand("Hipp")
                .build();

        adapter.save(product);

        var found = adapter.findByEan("406230345593");

        assertThat(found).isPresent();
    }
}