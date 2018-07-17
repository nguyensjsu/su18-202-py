package com.sjsu.reactive;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface OrderRepository {
    
   /* to get all orders placed */
	
Flux<Order>getAllOrders();

    /* to get order based on order id */
Mono<Order>getOrder(Integer id);

    /* to save user entered order */
Mono<Void>saveOrder(Mono<Order>orderMono);
    
    /* to update the already entered order */

Mono<Void>updateOrder(Mono<Order>orderMono);

    /* to delete order */
Mono<Void> deleteOrder(Integer id);

}
