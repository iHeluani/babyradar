package com.babyradar.products.infrastructure.persistence;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "product_offers")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProductOfferEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "product_id")
    private ProductEntity product;

    @Column(nullable = false)
    private String shopName;

    @Column(nullable = false)
    private String url;

    @Column(nullable = false)
    private Double price;

    private Double oldPrice;
    private Boolean inStock;

    private LocalDateTime firstSeenAt;
    private LocalDateTime lastSeenAt;
}