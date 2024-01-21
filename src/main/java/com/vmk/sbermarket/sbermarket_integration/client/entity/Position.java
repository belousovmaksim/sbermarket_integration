package com.vmk.sbermarket.sbermarket_integration.client.entity;

public class Position {
    private String id;
    private int originalQuantity;
    private int quantity;
    private String weight;
    private String replacedByID;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getOriginalQuantity() {
        return originalQuantity;
    }

    public void setOriginalQuantity(int originalQuantity) {
        this.originalQuantity = originalQuantity;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getWeight() {
        return weight;
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }

    public String getReplacedByID() {
        return replacedByID;
    }

    public void setReplacedByID(String replacedByID) {
        this.replacedByID = replacedByID;
    }
}