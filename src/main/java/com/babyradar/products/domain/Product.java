package com.babyradar.products.domain;

import lombok.Builder;
import lombok.Value;

/**
 * Producto base, independiente de la tienda concreta.
 */
@Value
@Builder
public class Product {

    Long id;                // opcional, lo gestionará la capa de persistencia
    String ean;             // puede ser null si no lo conocemos
    String name;
    String brand;
    ProductCategory category;

    boolean bio;
    boolean sugarFree;
    boolean palmOilFree;

    String recommendedAge;  // "+6M", "+12M", etc.
    String notes;
}