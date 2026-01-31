package com.example.hexagonal.domain.port;

import com.example.hexagonal.domain.model.Order;

import java.util.List;

public interface ListOrdersUseCase {
    List<Order> list();
}
