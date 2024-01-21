package com.vmk.sbermarket.sbermarket_integration.server.dao;

import com.vmk.sbermarket.sbermarket_integration.server.entity.Order;
import jakarta.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
@Repository
public class OrderDAOImp implements OrderDAO {
    @Autowired
    private EntityManager entityManager;

    @Override
    public void saveOrder(Order order) {
        entityManager.persist(order);
    }

    @Override
    public Order findByOriginalOrderId(String originalOrderId) {
            return entityManager.find(Order.class, originalOrderId);
    }

    @Override
    public void changeShipmentMethod(String newShipmentMethod, String originalOrderId) {
        entityManager.createNativeQuery("UPDATE orders SET shipment_method='"
                +newShipmentMethod+"' WHERE original_order_id='"
                +originalOrderId+"';").executeUpdate();
    }

    @Override
    public void orderCanceled(String originalOrderId) {
        entityManager.createNativeQuery("UPDATE orders SET event_type='order.canceled' WHERE original_order_id='"
                +originalOrderId+"';").executeUpdate();
    }

    @Override
    public void saveLogFullJson(String fullJson, String originalOrderId) {
        entityManager.createNativeQuery("UPDATE orders SET full_json='"+fullJson+"' WHERE original_order_id='"
                +originalOrderId+"';").executeUpdate();
    }

}
