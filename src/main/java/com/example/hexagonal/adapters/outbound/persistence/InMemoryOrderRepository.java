package com.example.hexagonal.adapters.outbound.persistence;

import com.example.hexagonal.domain.model.Order;
import com.example.hexagonal.domain.port.OrderRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Repository
public class InMemoryOrderRepository implements OrderRepository {
    private final List<Order> orders = new ArrayList<>();

    @Override
    public synchronized Order save(Order order) {
        orders.add(order);
        return order;
    }

    @Override
    public synchronized List<Order> findAll() {
        return Collections.unmodifiableList(new ArrayList<>(orders));
    }
}
