package com.cloudcart.order;

import com.cloudcart.order.testcontainers.TestcontainersConfiguration;
import org.springframework.boot.SpringApplication;

public class TestOrderServiceApplication {

	public static void main(String[] args) {
		SpringApplication.from(OrderServiceApplication::main).with(TestcontainersConfiguration.class).run(args);
	}

}
