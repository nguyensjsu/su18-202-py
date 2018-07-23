package com.sjsu.reactive;


import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.web.reactive.function.server.RequestPredicates.DELETE;
import static org.springframework.web.reactive.function.server.RequestPredicates.GET;
import static org.springframework.web.reactive.function.server.RequestPredicates.POST;
import static org.springframework.web.reactive.function.server.RequestPredicates.PUT;
import static org.springframework.web.reactive.function.server.RequestPredicates.accept;
import static org.springframework.web.reactive.function.server.RequestPredicates.contentType;
import static org.springframework.web.reactive.function.server.RequestPredicates.path;
import static org.springframework.web.reactive.function.server.RouterFunctions.nest;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;
import static org.springframework.web.reactive.function.server.RouterFunctions.toHttpHandler;

import java.io.IOException;

import org.springframework.http.MediaType;
import org.springframework.http.server.reactive.HttpHandler;
import org.springframework.http.server.reactive.ReactorHttpHandlerAdapter;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

import reactor.ipc.netty.http.server.HttpServer;

public class Server {

	public static final String HOST = "localhost";
	public static final int PORT = 8108;

	public static void main(String[] args) throws InterruptedException, IOException {
		Server server = new Server();
		server.startReactorServer();

		System.out.println("Press ENTER to exit.");
		System.in.read();
	}

	public void startReactorServer() throws InterruptedException {
		RouterFunction<ServerResponse> route = routingFunction();
		HttpHandler httpHandler = toHttpHandler(route);

		ReactorHttpHandlerAdapter adapter = new ReactorHttpHandlerAdapter(httpHandler);
		HttpServer server = HttpServer.create(HOST, PORT);
		server.newHandler(adapter).block();
	}
 
	public RouterFunction<ServerResponse> routingFunction() {
		OrderRepository repository = new OrderRepositoryConcrete();
		OrderHandler handler = new OrderHandler(repository);
		
		return nest (
				path("/order"),
				nest(
					accept(MediaType.ALL),
					route(GET("/"), handler::getAllOrders)
				)
				.andRoute(GET("/{id}"), handler::getOrder)
				.andRoute(POST("/").and(contentType(APPLICATION_JSON)), handler::createOrder)
				.andRoute(PUT("/").and(contentType(APPLICATION_JSON)), handler::updateOrder)
				.andRoute(DELETE("/{id}").and(contentType(APPLICATION_JSON)), handler::deleteOrder)
			);
	}
}
