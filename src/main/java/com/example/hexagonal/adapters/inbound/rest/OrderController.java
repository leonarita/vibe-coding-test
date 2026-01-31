package com.example.hexagonal.adapters.inbound.rest;

import com.example.hexagonal.domain.model.Order;
import com.example.hexagonal.domain.port.CreateOrderUseCase;
import com.example.hexagonal.domain.port.ListOrdersUseCase;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/orders")
public class OrderController {
    private final CreateOrderUseCase createOrderUseCase;
    private final ListOrdersUseCase listOrdersUseCase;

    public OrderController(CreateOrderUseCase createOrderUseCase, ListOrdersUseCase listOrdersUseCase) {
        this.createOrderUseCase = createOrderUseCase;
        this.listOrdersUseCase = listOrdersUseCase;
    }

    @GetMapping
    public List<OrderResponse> listOrders() {
        return listOrdersUseCase.list().stream()
                .map(OrderResponse::from)
                .toList();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public OrderResponse createOrder(@RequestBody CreateOrderRequest request) {
        Order order = createOrderUseCase.create(request.description());
        return OrderResponse.from(order);
    }

    public record CreateOrderRequest(String description) {}

    public record OrderResponse(String id, String description, String createdAt) {
        public static OrderResponse from(Order order) {
            return new OrderResponse(order.getId().toString(), order.getDescription(), order.getCreatedAt().toString());
        }
    }
}
