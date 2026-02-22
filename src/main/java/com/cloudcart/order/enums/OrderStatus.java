package com.cloudcart.order.enums;

import lombok.Getter;

@Getter
public enum OrderStatus {

    CREATED("CREATED"),
    PAYMENT_PENDING("PAYMENT_PENDING"),
    CANCELLED("CANCELLED"),
    PAYMENT_RECEIVED("PAYMENT_RECEIVED"),
    IN_PROCESS("IN_PROCESS"),
    DELIVERED("DELIVERED");

    public final String orderStatus;

    OrderStatus(String orderStatus) {
        this.orderStatus = orderStatus;
    }
}
