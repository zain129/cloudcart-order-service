package com.cloudcart.order.dto;

import com.cloudcart.order.enums.OrderStatus;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDateTime;

@AllArgsConstructor
@Getter
public class OrderResponse {
    private Long id;
    private String customerId;
    private OrderStatus status;
    private LocalDateTime createdAt;
}