package com.piecoffeeshop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.piecoffeeshop.repo.OrderRepository;
import com.piecoffeeshop.model.Cappuchino;
import com.piecoffeeshop.model.Latte;
import com.piecoffeeshop.model.MasalaChai;
import com.piecoffeeshop.model.Mocha;
import com.piecoffeeshop.model.Order;

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
		
		System.out.println("Inside make order");
		
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
		 //redirectAttributes.addAttribute(order);
		PaymentController.getCostbyOrder(order);
		//repository.save(order);
		 return "Saving to Cart. Make payment to process the order";
		//return new ResponseEntity<> (order, HttpStatus.OK);
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
