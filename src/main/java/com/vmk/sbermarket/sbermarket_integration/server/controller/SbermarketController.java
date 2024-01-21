package com.vmk.sbermarket.sbermarket_integration.server.controller;

import com.vmk.sbermarket.sbermarket_integration.client.Communication;
import com.vmk.sbermarket.sbermarket_integration.client.entity.Event;
import com.vmk.sbermarket.sbermarket_integration.server.entity.Order;
import com.vmk.sbermarket.sbermarket_integration.server.service.OrderService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/")
public class SbermarketController {
    @Autowired
    private Communication communication;
    @Autowired
    private OrderService orderService;
    @Value("${clientToken}")
    private String token;
    @PostMapping("sbermarket")
    @Transactional
    public ResponseEntity<Object> incomingRequestProcessing(@RequestBody Order order
            , @RequestHeader("Client-Token") String clientToken) {
        if (clientToken.equals(token)) {
            switch (order.getEventType()) {
                case "order.created" -> {
                    orderService.saveOrder(order);
                    int orderId = order.getId();
                    return ResponseEntity.ok("{\"status\": \"created\", \"number\": "
                            + orderId + ", \"expectedAssemblyTime\": \"2021-05-24T13:45:00+03:00\"}");
                }
                case "order.updated" -> {
                    String newShipmentMethod = order.getPayload().getShipmentMethod();
                    String originalOrderId = order.getPayload().getOriginalOrderId();
                    orderService.changeShipmentMethod(newShipmentMethod, originalOrderId);
                    return ResponseEntity.ok(newShipmentMethod + " " + order.getId() + " " + originalOrderId);
                }
                case "order.canceled" -> {
                    String originalOrderId = order.getPayload().getOriginalOrderId();
                    orderService.orderCanceled(originalOrderId);
                    return new ResponseEntity(HttpStatus.OK);
                }
                default -> {
                    String eventType = order.getEventType();
                    return new ResponseEntity("{\"error\": \"" + eventType + " нет подобного события\"}", HttpStatus.BAD_REQUEST);
                }
            }
        } else {
            return new ResponseEntity("{\"error\": \"not authorized\"}", HttpStatus.I_AM_A_TEAPOT);
        }
    }
    @Scheduled(fixedRate = 30000)
    public void getCommunication() {
        Event event = communication.outgoingEvent();
        communication.sendEvent(event);
    }
}