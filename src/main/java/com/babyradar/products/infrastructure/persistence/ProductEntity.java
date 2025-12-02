package com.babyradar.products.infrastructure.persistence;

import com.babyradar.products.domain.ProductCategory;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "products")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProductEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String ean;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String brand;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private ProductCategory category;

    private boolean bio;
    private boolean sugarFree;
    private boolean palmOilFree;

    private String recommendedAge;

    @Column(length = 1000)
    private String notes;
}