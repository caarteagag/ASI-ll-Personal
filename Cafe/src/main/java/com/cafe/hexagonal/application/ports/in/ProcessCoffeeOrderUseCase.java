package com.cafe.hexagonal.application.ports.in;

import com.cafe.hexagonal.domain.model.Order;

public interface ProcessCoffeeOrderUseCase {
    Order process(Order order);
}