package com.vmk.sbermarket.sbermarket_integration.client;

import com.vmk.sbermarket.sbermarket_integration.client.entity.Event;
import com.vmk.sbermarket.sbermarket_integration.client.entity.Payload;
import com.vmk.sbermarket.sbermarket_integration.client.entity.Position;
import com.vmk.sbermarket.sbermarket_integration.client.service.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Component
public class Communication {
    private final String URL = "https://api.sbermarket.ru/v3/notifications";
    @Autowired
    private RestTemplate restTemplate;
    @Autowired
    private EventService eventService;
    Event event;
    Payload payload;
    com.vmk.sbermarket.sbermarket_integration.client.entity.Order order;
    List<Position> positions;

    public Event outgoingEvent() {
        positions = eventService.positionsReady();
        order = eventService.orderReady();
        order.setPositions(positions);
        payload = eventService.payloadReady();
        payload.setOrder(order);
        event = eventService.eventReady();
        event.setPayload(payload);
        return event;
    }
    public void sendEvent(Event event) {
        HttpHeaders headers = new HttpHeaders();
        headers.add("Authorization", "Bearer your_access_token");
        headers.add("Content-Type", "application/json");

        HttpEntity<Event> requestEntity = new HttpEntity<>(event, headers);

        ResponseEntity<String> responseEntity =
                restTemplate.exchange(URL, HttpMethod.POST, requestEntity, String.class);
    }
}
