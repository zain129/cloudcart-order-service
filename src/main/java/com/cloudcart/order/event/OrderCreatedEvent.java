package com.cloudcart.order.event;

import com.cloudcart.order.enums.OrderStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;

@AllArgsConstructor
@Getter
@Builder
public class OrderCreatedEvent {

    private Long orderId;
    private String customerId;
    private OrderStatus status;
    private LocalDateTime createdAt;
}