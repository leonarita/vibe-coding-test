package com.example.hexagonal.domain.port;

import com.example.hexagonal.domain.model.Order;

public interface CreateOrderUseCase {
    Order create(String description);
}
