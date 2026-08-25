package com.cafe.hexagonal.application.ports.out;

import com.cafe.hexagonal.domain.model.CoffeeBean;

public interface InventoryPort {
    boolean hasEnough(CoffeeBean coffeeBean, int quantityInGrams);
}