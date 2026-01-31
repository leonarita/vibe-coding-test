package com.example.hexagonal.application;

import com.example.hexagonal.domain.model.Order;
import com.example.hexagonal.domain.port.CreateOrderUseCase;
import com.example.hexagonal.domain.port.ListOrdersUseCase;
import com.example.hexagonal.domain.port.OrderRepository;
import org.springframework.stereotype.Service;

import java.time.Clock;
import java.time.Instant;
import java.util.List;
import java.util.UUID;

@Service
public class OrderService implements CreateOrderUseCase, ListOrdersUseCase {
    private final OrderRepository orderRepository;
    private final Clock clock;

    public OrderService(OrderRepository orderRepository, Clock clock) {
        this.orderRepository = orderRepository;
        this.clock = clock;
    }

    @Override
    public Order create(String description) {
        Order order = new Order(UUID.randomUUID(), description, Instant.now(clock));
        return orderRepository.save(order);
    }

    @Override
    public List<Order> list() {
        return orderRepository.findAll();
    }
}
