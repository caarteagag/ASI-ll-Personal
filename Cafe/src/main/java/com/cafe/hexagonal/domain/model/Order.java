package com.cafe.hexagonal.domain.model;

import com.cafe.hexagonal.domain.exception.BusinessException;

public record Order(
        Long id,
        CoffeeBean coffeeBean,
        int quantityInGrams,
        String preparationMethod
) {

    public Order {
        if (coffeeBean == null) {
            throw new BusinessException("El grano de café es obligatorio");
        }
        if (quantityInGrams <= 0) {
            throw new BusinessException("La cantidad debe ser mayor que cero");
        }
        if (preparationMethod == null || preparationMethod.isBlank()) {
            throw new BusinessException("El método de preparación es obligatorio");
        }
    }
}