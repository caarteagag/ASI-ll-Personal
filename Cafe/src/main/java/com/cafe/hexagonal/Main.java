package com.cafe.hexagonal;

import com.cafe.hexagonal.application.usecases.ProcessCoffeeOrderService;
import com.cafe.hexagonal.domain.exception.BusinessException;
import com.cafe.hexagonal.infrastructure.adapters.in.console.CoffeeOrderConsoleAdapter;
import com.cafe.hexagonal.infrastructure.adapters.out.memory.InMemoryInventoryAdapter;
import com.cafe.hexagonal.infrastructure.adapters.out.memory.InMemoryOrderAdapter;

import java.util.Map;

public class Main {
    public static void main(String[] args) {
        InMemoryInventoryAdapter inventoryAdapter = new InMemoryInventoryAdapter(
                Map.of("Geisha", 1000, "Bourbon Rosado", 500)
        );
        InMemoryOrderAdapter orderAdapter = new InMemoryOrderAdapter();

        ProcessCoffeeOrderService processCoffeeOrderService = new ProcessCoffeeOrderService(
                inventoryAdapter,
                orderAdapter
        );
        CoffeeOrderConsoleAdapter consoleAdapter = new CoffeeOrderConsoleAdapter(
                processCoffeeOrderService
        );

        System.out.println("Pedido aprobado: " + consoleAdapter.processOrder(
                "Geisha", 250, "V60"
        ));

        try {
            consoleAdapter.processOrder("Geisha", 2000, "Espresso");
        } catch (BusinessException exception) {
            System.out.println("Pedido rechazado: " + exception.getMessage());
        }
    }
}