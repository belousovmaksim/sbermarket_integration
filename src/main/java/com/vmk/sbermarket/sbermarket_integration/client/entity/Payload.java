package com.vmk.sbermarket.sbermarket_integration.client.entity;
public class Payload {
    private String orderId;
    private Order order;

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }
}