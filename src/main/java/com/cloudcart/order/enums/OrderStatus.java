package com.cloudcart.order.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum OrderStatus {

    CREATED("CREATED"),
    PAYMENT_PENDING("PAYMENT_PENDING"),
    CANCELLED("CANCELLED"),
    PAYMENT_RECEIVED("PAYMENT_RECEIVED"),
    IN_PROCESS("IN_PROCESS"),
    DELIVERED("DELIVERED");

    private final String orderStatus;

}
