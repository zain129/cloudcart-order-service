package com.cloudcart.order.service;

import com.cloudcart.order.domain.Order;
import com.cloudcart.order.dto.OrderRequest;

public interface OrderService {
    Order createOrder(OrderRequest request);
}