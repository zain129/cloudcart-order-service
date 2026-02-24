package com.cloudcart.order.service.impl;

import com.cloudcart.order.domain.Order;
import com.cloudcart.order.dto.OrderRequest;
import com.cloudcart.order.enums.OrderStatus;
import com.cloudcart.order.event.OrderCreatedEvent;
import com.cloudcart.order.event.OrderEventProducer;
import com.cloudcart.order.repository.OrderRepository;
import com.cloudcart.order.service.OrderService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class OrderServiceImpl implements OrderService {

    private final OrderRepository orderRepository;
    private final OrderEventProducer orderEventProducer;

    /*
    - Persists order
    - Publishes event
    - No Kafka logic inside controller
     */
    @Override
    public Order createOrder(OrderRequest request) {

        Order order = new Order();
        order.setCustomerId(request.getCustomerId());
        order.setStatus(OrderStatus.CREATED);

        Order savedOrder = orderRepository.save(order);

        OrderCreatedEvent event = OrderCreatedEvent.builder()
                .orderId(savedOrder.getId())
                .customerId(savedOrder.getCustomerId())
                .status(savedOrder.getStatus())
                .createdAt(savedOrder.getCreatedAt())
                .build();

        orderEventProducer.publishOrderCreatedEvent(event);

        return savedOrder;
    }
}