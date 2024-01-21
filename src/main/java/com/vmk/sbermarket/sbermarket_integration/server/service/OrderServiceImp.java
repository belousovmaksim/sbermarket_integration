package com.vmk.sbermarket.sbermarket_integration.server.service;

import com.vmk.sbermarket.sbermarket_integration.server.dao.OrderDAO;
import com.vmk.sbermarket.sbermarket_integration.server.entity.Order;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderServiceImp implements OrderService {
    @Autowired
    private OrderDAO orderDAO;

    @Override
    @Transactional
    public void saveOrder(Order order) {
        orderDAO.saveOrder(order);
    }

    @Override
    @Transactional
    public Order findByOriginalOrderId(String originalOrderId) {
        return orderDAO.findByOriginalOrderId(originalOrderId);
    }

    @Override
    @Transactional
    public void changeShipmentMethod(String newShipmentMethod, String originalOrderId) {
        orderDAO.changeShipmentMethod(newShipmentMethod, originalOrderId);
    }

    @Override
    @Transactional
    public void orderCanceled(String originalOrderId) {
        orderDAO.orderCanceled(originalOrderId);
    }

    @Override
    public void saveLogFullJson(String fullJson, String originalOrderId) {
        orderDAO.saveLogFullJson(fullJson, originalOrderId);
    }
}