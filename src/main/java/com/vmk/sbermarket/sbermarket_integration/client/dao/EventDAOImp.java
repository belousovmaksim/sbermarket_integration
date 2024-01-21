package com.vmk.sbermarket.sbermarket_integration.client.dao;

import com.vmk.sbermarket.sbermarket_integration.client.entity.Event;
import com.vmk.sbermarket.sbermarket_integration.client.entity.Order;
import com.vmk.sbermarket.sbermarket_integration.client.entity.Payload;
import com.vmk.sbermarket.sbermarket_integration.client.entity.Position;
import jakarta.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class EventDAOImp implements EventDAO {
    @Autowired
    private EntityManager entityManager;

    @Override
    public Event eventReady() {
        String result = (String) entityManager.createNativeQuery("SELECT event_type_for_sm FROM orders " +
                "WHERE orders.event_type_for_sm = 'ready_for_delivery';")
                .setMaxResults(1)
                .getSingleResult();
        Event event = new Event();
        event.setType(result);
        return event;
    }

    @Override
    public Payload payloadReady() {
        String result = (String) entityManager.createNativeQuery("SELECT original_order_id FROM orders " +
                        "WHERE orders.event_type_for_sm = 'ready_for_delivery';")
                .setMaxResults(1)
                .getSingleResult();
        Payload payload = new Payload();
        payload.setOrderId(result);
        return payload;
    }

    @Override
    public Order orderReady() {
        Object[] result = (Object[]) entityManager.createNativeQuery("SELECT original_order_id, changed FROM orders " +
                        "WHERE event_type_for_sm = 'ready_for_delivery';")
                .setMaxResults(1)
                .getSingleResult();
        Order order = new Order();
        order.setOriginalOrderId((String) result[0]);
        order.setChanged((Boolean) result[1]);
        return order;
    }

    @Override
    public List<Position> positionsReady() {
        List<Object[]> resultList = entityManager.createNativeQuery("SELECT positions.id, positions.original_quantity, positions.quantity, positions.weight, positions.replaced_by_id " +
                "FROM orders INNER JOIN positions ON positions.position_fk = orders.id " +
                "WHERE orders.event_type_for_sm = 'ready_for_delivery';").getResultList();

        List<Position> positions = new ArrayList<>();
        for (Object[] row : resultList) {
            Position position = new Position();
            position.setId((String) row[0]);
            position.setOriginalQuantity((Integer) row[1]);
            position.setQuantity((Integer) row[2]);
            position.setWeight((String) row[3]);
            position.setReplacedByID((String) row[4]);
            positions.add(position);
        }
        return positions;
    }
}