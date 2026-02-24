package com.cloudcart.order.dto;

import com.cloudcart.order.enums.OrderStatus;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@NoArgsConstructor
@Getter
public class OrderResponse {
    private Long id;
    private String customerId;
    private OrderStatus status;
    private LocalDateTime createdAt;

    public OrderResponse(Long id, String customerId, OrderStatus status, LocalDateTime createdAt) {
        this.id = id;
        this.customerId = customerId;
        this.status = status;
        this.createdAt = createdAt;
    }
}