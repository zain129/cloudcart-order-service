package com.cloudcart.order.service.impl;

import com.cloudcart.order.domain.Order;
import com.cloudcart.order.dto.OrderRequest;
import com.cloudcart.order.repository.OrderRepository;
import com.cloudcart.order.service.OrderService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class OrderServiceImpl implements OrderService {

    private final OrderRepository orderRepository;

    @Override
    public Order createOrder(OrderRequest request) {
        Order order = new Order();
        order.setCustomerId(request.getCustomerId());
        return orderRepository.save(order);
    }
}