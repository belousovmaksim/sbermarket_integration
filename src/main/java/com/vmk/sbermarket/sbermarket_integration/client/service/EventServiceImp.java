package com.vmk.sbermarket.sbermarket_integration.client.service;

import com.vmk.sbermarket.sbermarket_integration.client.dao.EventDAO;
import com.vmk.sbermarket.sbermarket_integration.client.entity.Event;
import com.vmk.sbermarket.sbermarket_integration.client.entity.Order;
import com.vmk.sbermarket.sbermarket_integration.client.entity.Payload;
import com.vmk.sbermarket.sbermarket_integration.client.entity.Position;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class EventServiceImp implements EventService{
    @Autowired
    private EventDAO eventDAO;
    @Override
    public Event eventReady() {
        return eventDAO.eventReady();
    }

    @Override
    public Payload payloadReady() {
        return eventDAO.payloadReady();
    }

    @Override
    public Order orderReady() {
        return eventDAO.orderReady();
    }

    @Override
    public List<Position> positionsReady() {
        return eventDAO.positionsReady();
    }
}
