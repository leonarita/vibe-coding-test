# Hexagonal Architecture (Spring Boot 4)

This project demonstrates a basic hexagonal (ports and adapters) architecture using Spring Boot 4.

## Structure

- `domain` — Pure domain model and port definitions.
  - `domain/model` — Domain entities.
  - `domain/port` — Inbound and outbound ports.
- `application` — Application services that implement inbound ports and depend on outbound ports.
- `adapters/inbound` — Delivery mechanisms (REST in this sample).
- `adapters/outbound` — Infrastructure implementations (in-memory persistence in this sample).
- `config` — Spring configuration.

## Example flow

1. `OrderController` (inbound adapter) receives a REST request.
2. The controller calls the `CreateOrderUseCase` or `ListOrdersUseCase` ports.
3. `OrderService` (application layer) handles the business logic and uses the `OrderRepository` outbound port.
4. `InMemoryOrderRepository` (outbound adapter) persists the order in memory.

## Run locally

```bash
mvn spring-boot:run
```

Then:

```bash
curl -X POST localhost:8080/orders -H 'Content-Type: application/json' -d '{"description":"First order"}'
curl localhost:8080/orders
```
