package com.cafe.hexagonal.infrastructure.adapters.in.console;

import com.cafe.hexagonal.application.ports.in.ProcessCoffeeOrderUseCase;
import com.cafe.hexagonal.domain.model.CoffeeBean;
import com.cafe.hexagonal.domain.model.Order;

public class CoffeeOrderConsoleAdapter {
    private final ProcessCoffeeOrderUseCase processCoffeeOrderUseCase;

    public CoffeeOrderConsoleAdapter(ProcessCoffeeOrderUseCase processCoffeeOrderUseCase) {
        this.processCoffeeOrderUseCase = processCoffeeOrderUseCase;
    }

    public Order processOrder(String beanType, int quantityInGrams, String preparationMethod) {
        Order order = new Order(
                null,
                new CoffeeBean(beanType),
                quantityInGrams,
                preparationMethod
        );

        return processCoffeeOrderUseCase.process(order);
    }
}