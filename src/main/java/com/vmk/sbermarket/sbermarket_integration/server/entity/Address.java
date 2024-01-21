package com.vmk.sbermarket.sbermarket_integration.server.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.Embeddable;

@Embeddable
public class Address {
    @JsonProperty("full_address")
    private String fullAddress;

    public Address() {
    }

    public Address(String fullAddress) {
        this.fullAddress = fullAddress;
    }

    public String getFullAddress() {
        return fullAddress;
    }

    public void setFullAddress(String fullAddress) {
        this.fullAddress = fullAddress;
    }

    @Override
    public String toString() {
        return "Address{" +
                "fullAddress='" + fullAddress + '\'' +
                '}';
    }
}
