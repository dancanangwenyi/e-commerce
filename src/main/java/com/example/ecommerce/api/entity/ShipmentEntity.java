package com.example.ecommerce.api.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

@Entity
@Table(name = "shipment")
public class ShipmentEntity {
    @Id
    @GeneratedValue
    @Column(name = "ID", updatable = false, nullable = false)
    private UUID id;

    @Column(name = "EST_DELIVERY_DATE")
    private Timestamp estDeliveryDate;

    @Column(name = "CARRIER")
    private String carrier;

    public UUID getId() {
        return id;
    }

    public ShipmentEntity setId(UUID id) {
        this.id = id;
        return this;
    }

    public Timestamp getEstDeliveryDate() {
        return estDeliveryDate;
    }

    public ShipmentEntity setEstDeliveryDate(Timestamp estDeliveryDate) {
        this.estDeliveryDate = estDeliveryDate;
        return this;
    }

    public String getCarrier() {
        return carrier;
    }

    public ShipmentEntity setCarrier(String carrier) {
        this.carrier = carrier;
        return this;
    }

}
