package com.sjsu.reactive;

import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.web.reactive.function.BodyInserters.fromObject;

import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public class OrderHandler {

	private final OrderRepository orderRepository;
	
	public OrderHandler(OrderRepository orderRepository){
		this.orderRepository = orderRepository;
	}
	
	public Mono<ServerResponse> getAllOrders(ServerRequest request){
		Flux<Order> orders = this.orderRepository.getAllOrders();
		return ServerResponse.ok().contentType(APPLICATION_JSON).body(orders, Order.class);
	}
	
public Mono<ServerResponse> getOrder(ServerRequest request){
		
		int orderId = Integer.valueOf(request.pathVariable("id"));
		
		System.out.println("trap "+ orderId);
		
		Mono<ServerResponse> notFound = ServerResponse.notFound().build();
		Mono<Order> orderMono = this.orderRepository.getOrder(orderId);
		
		return orderMono
				.flatMap(order -> ServerResponse.ok().contentType(APPLICATION_JSON).body(fromObject(order)))
				.switchIfEmpty(notFound);
}

public Mono<ServerResponse> createOrder(ServerRequest request) {
	Mono<Order> order = request.bodyToMono(Order.class);
	return ServerResponse.ok().build(this.orderRepository.saveOrder(order));
}

public Mono<ServerResponse> updateOrder(ServerRequest request) {
	Mono<Order> order = request.bodyToMono(Order.class);
	return ServerResponse.ok().build(this.orderRepository.updateOrder(order));
}

public Mono<ServerResponse> deleteOrder(ServerRequest request) {		
	int orderId = Integer.valueOf(request.pathVariable("id"));
	return ServerResponse.ok().build(this.orderRepository.deleteOrder(orderId));
}
}