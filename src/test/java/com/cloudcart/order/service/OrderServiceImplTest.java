package com.cloudcart.order.service;

import com.cloudcart.order.domain.Order;
import com.cloudcart.order.dto.OrderRequest;
import com.cloudcart.order.enums.OrderStatus;
import com.cloudcart.order.repository.OrderRepository;
import com.cloudcart.order.service.impl.OrderServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.*;

class OrderServiceImplTest {

    private OrderRepository orderRepository;
    private OrderService orderService;

    @BeforeEach
    void setUp() {
        orderRepository = mock(OrderRepository.class);
        orderService = new OrderServiceImpl(orderRepository);
    }

    @Test
    void createOrder_shouldReturnSavedOrder() {
        OrderRequest request = new OrderRequest();
        request.setCustomerId("cust123");

        Order savedOrder = new Order();
        savedOrder.setCustomerId("cust123");
//        savedOrder.setStatus(OrderStatus.CREATED);
        savedOrder.setId(1L);

        when(orderRepository.save(any(Order.class))).thenReturn(savedOrder);

        Order result = orderService.createOrder(request);

        assertNotNull(result);
        assertEquals("cust123", result.getCustomerId());
        assertEquals(OrderStatus.CREATED, result.getStatus());

        verify(orderRepository, times(1)).save(any(Order.class));
    }
}