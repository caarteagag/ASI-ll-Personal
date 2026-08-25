package com.cafe.hexagonal.domain.model;

import com.cafe.hexagonal.domain.exception.BusinessException;

public record CoffeeBean(String type) {

    public CoffeeBean {
        if (type == null || type.isBlank()) {
            throw new BusinessException("El tipo de grano es obligatorio");
        }
    }
}