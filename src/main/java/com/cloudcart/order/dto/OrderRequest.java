package com.cloudcart.order.dto;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OrderRequest {
    private String customerId;
    private Long productId;
    private Integer quantity;
}