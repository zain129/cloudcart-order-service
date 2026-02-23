package com.cloudcart.order.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDateTime;

@AllArgsConstructor
@Getter
public class OrderResponse {
    private Long id;
    private String customerId;
    private String status;
    private LocalDateTime createdAt;
}