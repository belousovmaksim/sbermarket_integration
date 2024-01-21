package com.vmk.sbermarket.sbermarket_integration.server.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
@Entity
@Table(name = "orders")
public class Order {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "event_type")
    @JsonProperty("event_type")
    private String eventType;
    @Column(name = "timestamp")
    @JsonProperty("timestamp")
    private String timestamp;
    @Embedded
    @AttributeOverrides({
            @AttributeOverride( name = "originalOrderId", column = @Column(name = "original_order_id")),
            @AttributeOverride( name = "storeID", column = @Column(name = "store_id")),
            @AttributeOverride( name = "comment", column = @Column(name = "comment")),
            @AttributeOverride( name = "shipmentMethod", column = @Column(name = "shipment_method")),
            @AttributeOverride( name = "replacementPolicy", column = @Column(name = "replacement_policy"))
    })
    private Payload payload;

    public Order() {
    }

    public Order(String eventType, String timestamp, Payload payload) {
        this.eventType = eventType;
        this.timestamp = timestamp;
        this.payload = payload;
    }

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getEventType() {
        return eventType;
    }
    public void setEventType(String eventType) {
        this.eventType = eventType;
    }
    public String getTimestamp() {
        return timestamp;
    }
    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }
    public Payload getPayload() {
        return payload;
    }
    public void setPayload(Payload payload) {
        this.payload = payload;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", eventType='" + eventType + '\'' +
                ", timestamp='" + timestamp + '\'' +
                ", payload=" + payload +
                '}';
    }
}