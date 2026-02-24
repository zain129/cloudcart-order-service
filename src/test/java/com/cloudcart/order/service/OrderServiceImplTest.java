package com.cloudcart.order.service;

import com.cloudcart.order.domain.Order;
import com.cloudcart.order.dto.OrderRequest;
import com.cloudcart.order.enums.OrderStatus;
import com.cloudcart.order.event.OrderCreatedEvent;
import com.cloudcart.order.event.OrderEventProducer;
import com.cloudcart.order.repository.OrderRepository;
import com.cloudcart.order.service.impl.OrderServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

class OrderServiceImplTest {

    private OrderRepository orderRepository;
    private OrderEventProducer orderEventProducer;
    private OrderService orderService;

    @BeforeEach
    void setUp() {
        orderRepository = mock(OrderRepository.class);
        orderEventProducer = mock(OrderEventProducer.class);
        orderService = new OrderServiceImpl(orderRepository, orderEventProducer);
    }

    @Test
    void createOrder_shouldPersistOrderAndPublishEvent() {

        // Arrange
        OrderRequest request = new OrderRequest();
        request.setCustomerId("cust123");

        Order savedOrder = new Order();
        savedOrder.setCustomerId("cust123");
        savedOrder.setStatus(OrderStatus.CREATED);
        savedOrder.setId(1L);

        when(orderRepository.save(any(Order.class))).thenReturn(savedOrder);

        // Act
        Order result = orderService.createOrder(request);

        // Assert
        assertNotNull(result);
        assertEquals("cust123", result.getCustomerId());
        assertEquals(OrderStatus.CREATED, result.getStatus());

        verify(orderRepository, times(1)).save(any(Order.class));
        verify(orderEventProducer, times(1))
                .publishOrderCreatedEvent(any(OrderCreatedEvent.class));
    }
}