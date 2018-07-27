package com.piecoffeeshop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import com.piecoffeeshop.repo.OrderRepository;
import com.piecoffeeshop.model.Order;
import com.piecoffeeshop.model.OrderServiceImplementation;

/**
 * 
 * @author Abhinaya Yelipeddi
 * This is the web controller class to Manage Orders.
 * We have for REST API implementations
 * makeorder --- to create an order and interact with payments API
 * showall ---- to show all the orders for which payments are made successfully
 * deletebyid ---- to delete an order based on id
 * orderbyid ---- to show an order based on id
 *
 */

@RestController
public class OrderController {

	@Autowired
	OrderRepository repository;

	@RequestMapping("/deleteall")
	public String deleteall() {
		repository.deleteAll();
		return "All Orders Deleted";
	}

	@RequestMapping(value = "/makeorder", method = RequestMethod.POST, produces = "application/json")
	public String makeorder(@RequestBody Order order,RedirectAttributes redirectAttributes) {
		
		if (!order.getOrderName().isEmpty()) {
		System.out.println("Inside make order");
		OrderServiceImplementation orderImpl = new OrderServiceImplementation();		
		PaymentController.getCostbyOrder(orderImpl.getSpecificOrder(order));	
		 return "Saving to Cart. Make payment to process the order";
		} else {
			return "Order is empty. Please enter the order correctly";
		}
		
	}

	@RequestMapping("/showall")
	public String showAll() {
		String result = "";
		Iterable<Order> orders = repository.findAll();

		for (Order ord : orders) {
			result += ord.toString() + "<br>";
		}
		return result;
	}

	@RequestMapping("/orderbyid")
	public String orderById(@RequestParam("id") String id) {
		String result = "";
		result = repository.findOne(id).toString();
		return result;
	}
	
	@RequestMapping("/deletebyid")
	public String deleteById(@RequestParam("id") String id) {		
		repository.delete(id);
		return "Deleted the Order";
	}

	
}
