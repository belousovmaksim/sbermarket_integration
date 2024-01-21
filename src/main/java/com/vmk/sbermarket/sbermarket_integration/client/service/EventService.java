package com.vmk.sbermarket.sbermarket_integration.client.service;

import com.vmk.sbermarket.sbermarket_integration.client.entity.Event;
import com.vmk.sbermarket.sbermarket_integration.client.entity.Order;
import com.vmk.sbermarket.sbermarket_integration.client.entity.Payload;
import com.vmk.sbermarket.sbermarket_integration.client.entity.Position;

import java.util.List;

public interface EventService {
    public Event eventReady();
    public Payload payloadReady();
    public Order orderReady();
    public List<Position> positionsReady();
}
