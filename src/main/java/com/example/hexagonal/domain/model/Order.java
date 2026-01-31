package com.example.hexagonal.domain.model;

import java.time.Instant;
import java.util.Objects;
import java.util.UUID;

public final class Order {
    private final UUID id;
    private final String description;
    private final Instant createdAt;

    public Order(UUID id, String description, Instant createdAt) {
        this.id = Objects.requireNonNull(id, "id must not be null");
        this.description = Objects.requireNonNull(description, "description must not be null");
        this.createdAt = Objects.requireNonNull(createdAt, "createdAt must not be null");
    }

    public UUID getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    public Instant getCreatedAt() {
        return createdAt;
    }
}
