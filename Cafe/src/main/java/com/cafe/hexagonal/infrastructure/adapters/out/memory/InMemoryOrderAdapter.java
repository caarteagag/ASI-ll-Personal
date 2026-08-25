package com.cafe.hexagonal.infrastructure.adapters.out.memory;

import com.cafe.hexagonal.application.ports.out.OrderRepositoryPort;
import com.cafe.hexagonal.domain.model.Order;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

public class InMemoryOrderAdapter implements OrderRepositoryPort {
    private final AtomicLong nextId = new AtomicLong(1);
    private final List<Order> orders = new ArrayList<>();

    @Override
    public Order save(Order order) {
        Order savedOrder = order.id() == null
                ? new Order(nextId.getAndIncrement(), order.coffeeBean(),
                order.quantityInGrams(), order.preparationMethod())
                : order;
        orders.add(savedOrder);
        return savedOrder;
    }

    public List<Order> findAll() {
        return List.copyOf(orders);
    }
}