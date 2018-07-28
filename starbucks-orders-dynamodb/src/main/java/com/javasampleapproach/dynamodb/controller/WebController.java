package com.javasampleapproach.dynamodb.controller;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.javasampleapproach.dynamodb.model.*;
import com.javasampleapproach.dynamodb.repo.OrderRepository;
import com.piecoffeeshop.model.Cappuchino;
import com.piecoffeeshop.model.Latte;
import com.piecoffeeshop.model.MasalaChai;
import com.piecoffeeshop.model.Mocha;
import com.piecoffeeshop.model.Order;

@RestController
public class WebController {

	@Autowired
	OrderRepository repository;

	@RequestMapping("/deleteall")
	public String deleteall() {
		repository.deleteAll();
		return "All Orders Deleted";
	}

	@RequestMapping(value = "/saveorder", method = RequestMethod.POST, produces = "application/json")
	public String saveorder(@RequestBody Order order) {
		
		System.out.println("Inside Save order");
		
		/* If order is Mocha */
		if (order.getOrderName().toString().equals("Mocha")) {
			Mocha m = new Mocha();
			String[] mo = { order.getSize().toString(), order.getQuantity().toString() };
			m.setOptions(mo);
			order.setCost(m.getCost().toString());
		}
		
		/* If order is MasalaChai */
		if (order.getOrderName().toString().equals("MasalaChai")) {
			MasalaChai mc = new MasalaChai();
			String[] mco = { order.getSize().toString(), order.getQuantity().toString() };
			mc.setOptions(mco);
			order.setCost(mc.getCost().toString());
		}
		
		/* If order is Cappuchino */
		if (order.getOrderName().toString().equals("Cappuchino")) {
			Cappuchino c = new Cappuchino();
			System.out.println("cappuchino bef adding cost in web=" + order.getCost());
			String[] co = { order.getSize().toString(), order.getQuantity().toString() };
			c.setOptions(co);
			order.setCost(c.getCost().toString());
			System.out.println("cappuchino after adding cost in web=" + order.getCost());
		}
		
		/* If order is Latte */
		if (order.getOrderName().toString().equals("Latte")) {
			Latte l = new Latte();
			String[] lo = { order.getSize().toString(), order.getQuantity().toString() };
			l.setOptions(lo);
			order.setCost(l.getCost().toString());
		}
		repository.save(order);

		return "Order Saved";
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
		//String result = "";
		repository.delete(id);
		return "Deleted the Order";
	}

	
}
