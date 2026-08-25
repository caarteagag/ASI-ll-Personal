package com.cafe.hexagonal.application.usecases;

import com.cafe.hexagonal.application.ports.in.ProcessCoffeeOrderUseCase;
import com.cafe.hexagonal.application.ports.out.InventoryPort;
import com.cafe.hexagonal.application.ports.out.OrderRepositoryPort;
import com.cafe.hexagonal.domain.exception.BusinessException;
import com.cafe.hexagonal.domain.model.Order;

public class ProcessCoffeeOrderService implements ProcessCoffeeOrderUseCase {
    private final InventoryPort inventoryPort;
    private final OrderRepositoryPort orderRepositoryPort;

    public ProcessCoffeeOrderService(
            InventoryPort inventoryPort,
            OrderRepositoryPort orderRepositoryPort
    ) {
        this.inventoryPort = inventoryPort;
        this.orderRepositoryPort = orderRepositoryPort;
    }

    @Override
    public Order process(Order order) {
        boolean inventoryAvailable = inventoryPort.hasEnough(
                order.coffeeBean(),
                order.quantityInGrams()
        );

        if (!inventoryAvailable) {
            throw new BusinessException("No hay inventario suficiente para el grano solicitado");
        }

        return orderRepositoryPort.save(order);
    }
}