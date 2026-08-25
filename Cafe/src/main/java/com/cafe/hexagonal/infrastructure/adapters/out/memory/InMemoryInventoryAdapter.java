package com.cafe.hexagonal.infrastructure.adapters.out.memory;

import com.cafe.hexagonal.application.ports.out.InventoryPort;
import com.cafe.hexagonal.domain.model.CoffeeBean;

import java.util.HashMap;
import java.util.Map;

public class InMemoryInventoryAdapter implements InventoryPort {
    private final Map<String, Integer> inventoryInGrams;

    public InMemoryInventoryAdapter(Map<String, Integer> initialInventory) {
        this.inventoryInGrams = new HashMap<>(initialInventory);
    }

    @Override
    public boolean hasEnough(CoffeeBean coffeeBean, int quantityInGrams) {
        int availableGrams = inventoryInGrams.getOrDefault(coffeeBean.type(), 0);
        return availableGrams >= quantityInGrams;
    }
}