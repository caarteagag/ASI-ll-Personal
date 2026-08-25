package com.cafe.hexagonal.application.ports.out;

import com.cafe.hexagonal.domain.model.Order;

public interface OrderRepositoryPort {
    Order save(Order order);
}