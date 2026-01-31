package com.example.hexagonal.domain.port;

import com.example.hexagonal.domain.model.Order;

import java.util.List;

public interface OrderRepository {
    Order save(Order order);

    List<Order> findAll();
}
