package com.babyradar.products.application;

import com.babyradar.products.domain.*;
import com.babyradar.products.util.ProductMother;
import com.babyradar.products.util.ProductOfferMother;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class ProductApplicationServiceTest {

    @Mock
    private ProductRepository productRepository;

    @Mock
    private ProductOfferRepository productOfferRepository;

    @InjectMocks
    private ProductApplicationService service;

    private Product hippCereal;
    private ProductOffer offer1;
    private ProductOffer offer2;

    @BeforeEach
    void setUp() {
        hippCereal = ProductMother.hippMulticereales();   // asumiendo que ya existe
        offer1 = ProductOfferMother.carrefourOffer(hippCereal);
        offer2 = ProductOfferMother.amazonOffer(hippCereal);
    }

    @Test
    void getAllProducts_returnsProductsFromRepository() {
        when(productRepository.findAll()).thenReturn(List.of(hippCereal));

        List<Product> result = service.getAllProducts();

        assertThat(result).containsExactly(hippCereal);
        verify(productRepository).findAll();
        verifyNoMoreInteractions(productRepository, productOfferRepository);
    }

    @Test
    void getProductByEan_returnsProduct_whenExists() {
        String ean = hippCereal.getEan();
        when(productRepository.findByEan(ean)).thenReturn(Optional.of(hippCereal));

        Product result = service.getProductByEan(ean);

        assertThat(result).isEqualTo(hippCereal);
        verify(productRepository).findByEan(ean);
        verifyNoMoreInteractions(productRepository, productOfferRepository);
    }

    @Test
    void getProductByEan_throwsException_whenNotExists() {
        String ean = "0000000000000";
        when(productRepository.findByEan(ean)).thenReturn(Optional.empty());

        assertThatThrownBy(() -> service.getProductByEan(ean))
                .isInstanceOf(ProductNotFoundException.class)
                .hasMessageContaining(ean);

        verify(productRepository).findByEan(ean);
        verifyNoMoreInteractions(productRepository, productOfferRepository);
    }

    @Test
    void getOffersForProductEan_returnsOffers_whenProductExists() {
        String ean = hippCereal.getEan();

        when(productRepository.findByEan(ean)).thenReturn(Optional.of(hippCereal));
        when(productOfferRepository.findByProduct(hippCereal))
                .thenReturn(List.of(offer1, offer2));

        List<ProductOffer> result = service.getOffersForProductEan(ean);

        assertThat(result).containsExactly(offer1, offer2);
        verify(productRepository).findByEan(ean);
        verify(productOfferRepository).findByProduct(hippCereal);
        verifyNoMoreInteractions(productRepository, productOfferRepository);
    }

    @Test
    void saveProduct_delegatesToRepository() {
        when(productRepository.save(hippCereal)).thenReturn(hippCereal);

        Product result = service.saveProduct(hippCereal);

        assertThat(result).isEqualTo(hippCereal);
        verify(productRepository).save(hippCereal);
        verifyNoMoreInteractions(productRepository, productOfferRepository);
    }

    @Test
    void saveOffer_delegatesToRepository() {
        when(productOfferRepository.save(offer1)).thenReturn(offer1);

        ProductOffer result = service.saveOffer(offer1);

        assertThat(result).isEqualTo(offer1);
        verify(productOfferRepository).save(offer1);
        verifyNoMoreInteractions(productRepository, productOfferRepository);
    }
}