package com.vmk.sbermarket.sbermarket_integration.server.dao;

import com.vmk.sbermarket.sbermarket_integration.server.entity.Order;

public interface OrderDAO {
    public void saveOrder(Order order);
    public Order findByOriginalOrderId(String originalOrderId);
    public void changeShipmentMethod(String newShipmentMethod, String originalOrderId);
    public void orderCanceled(String originalOrderId);
    public void saveLogFullJson(String fullJson, String originalOrderId);
}
