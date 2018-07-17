package com.sjsu.reactive;

import java.util.HashMap;
import java.util.Map;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public class OrderRepositoryConcrete implements OrderRepository {

	//  Orders
	private final Map<Integer, Order> orders = new HashMap<>();

	// test orders
	public OrderRepositoryConcrete() {
		this.orders.put(1, new Order(1, "Coffee"));
		this.orders.put(2, new Order(2, "Cappuchino"));
		this.orders.put(3, new Order(3, "Latte"));
	}
	
	
}
