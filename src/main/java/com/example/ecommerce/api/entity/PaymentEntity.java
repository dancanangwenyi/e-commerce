package com.example.ecommerce.api.entity;

import jakarta.persistence.*;

import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

@Entity
@Table(name = "payment")
public class PaymentEntity {

    @Id
    @GeneratedValue
    @Column(name = "ID", updatable = false, nullable = false)
    private UUID id;

    @Column(name="AUTHORIZED")
    private boolean authorized;

    @Column(name = "MESSAGE")
    private String message;

    @OneToOne(mappedBy = "paymentEntity")
    private OrderEntity orderEntity;

    public UUID getId() {
        return id;
    }

    public PaymentEntity setId(UUID id) {
        this.id = id;
        return this;
    }

    public boolean isAuthorized() {
        return authorized;
    }

    public PaymentEntity setAuthorized(boolean authorized) {
        this.authorized = authorized;
        return this;
    }

    public String getMessage() {
        return message;
    }

    public PaymentEntity setMessage(String message) {
        this.message = message;
        return this;
    }
}
