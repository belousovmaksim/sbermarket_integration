package com.vmk.sbermarket.sbermarket_integration.server.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;

import java.util.List;
@Embeddable
public class Payload {
    @JsonProperty("originalOrderId")
    private String originalOrderId;
    @JsonProperty("storeID")
    private String storeId;
    @JsonProperty("comment")
    private String comment;
    @JsonProperty("shipmentMethod")
    private String shipmentMethod;
    @JsonProperty("replacementPolicy")
    private String replacementPolicy;
    @AttributeOverride( name = "name", column = @Column(name = "full_name"))
    private Customer customer;
    @AttributeOverride( name = "fullAddress", column = @Column(name = "full_address"))
    private Address address;
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "position_fk")
    private List<Position> positions;

    public Payload() {
    }

    public Payload(String originalOrderId, String storeId, String comment, String shipmentMethod, String replacementPolicy, Customer customer, Address address, List<Position> positions) {
        this.originalOrderId = originalOrderId;
        this.storeId = storeId;
        this.comment = comment;
        this.shipmentMethod = shipmentMethod;
        this.replacementPolicy = replacementPolicy;
        this.customer = customer;
        this.address = address;
        this.positions = positions;
    }

    public List<Position> getPositions() {
        return positions;
    }

    public void setPositions(List<Position> positions) {
        this.positions = positions;
    }

    public Customer getCustomer() {
        return customer;
    }

    public String getOriginalOrderId() {
        return originalOrderId;
    }

    public void setOriginalOrderId(String originalOrderId) {
        this.originalOrderId = originalOrderId;
    }

    public String getStoreId() {
        return storeId;
    }

    public void setStoreId(String storeId) {
        this.storeId = storeId;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getShipmentMethod() {
        return shipmentMethod;
    }

    public void setShipmentMethod(String shipmentMethod) {
        this.shipmentMethod = shipmentMethod;
    }

    public String getReplacementPolicy() {
        return replacementPolicy;
    }

    public void setReplacementPolicy(String replacementPolicy) {
        this.replacementPolicy = replacementPolicy;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Payload{" +
                "originalOrderId='" + originalOrderId + '\'' +
                ", storeId='" + storeId + '\'' +
                ", comment='" + comment + '\'' +
                ", shipmentMethod='" + shipmentMethod + '\'' +
                ", replacementPolicy='" + replacementPolicy + '\'' +
                ", customer=" + customer +
                ", address=" + address +
                ", positions=" + positions +
                '}';
    }
}
