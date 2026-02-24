package com.cloudcart.order.event;

import com.cloudcart.order.enums.OrderStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Builder
public class OrderCreatedEvent implements Serializable {

    private Long orderId;
    private String customerId;
    private OrderStatus status;
    private LocalDateTime createdAt;
}