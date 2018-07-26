package com.piecoffeeshop.controller;

import java.util.Arrays;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.piecoffeeshop.model.Card;
import com.piecoffeeshop.model.Greeting;
import com.piecoffeeshop.repo.CardRepository;

@RestController
public class AppController{
	
	@Autowired
	CardRepository repository;
			
	private static final String template = "Hello, %s!";
	private final AtomicLong counter = new AtomicLong(); 

	private Card cc = new Card("1234567887654321","9876","51.00");

	@RequestMapping("/greeting")
	public Greeting greeting(@RequestParam(value="name", defaultValue="World") String name){
		return new Greeting(counter.incrementAndGet(), String.format(template, name));
	}

	@RequestMapping("/getBalance")
	public Card getBalance(@RequestParam(value="cardNum", defaultValue="1234567887654321") String cardNum){
		return cc;
	}
	
	@RequestMapping("/findall")
	public String findAll() {
		String result = "";
		Iterable<Card> cards = repository.findAll();
 
		for (Card cust : cards) {
			result += cust.toString() + "<br>";
		}
 
		return result;
	}
	
	@RequestMapping("/delete")
	public String delete() {
		repository.deleteAll();
		return "Done";
	}
	
	@RequestMapping(value = "/savecard", method = RequestMethod.POST)
	public String save(@RequestBody Map<String, String> params) {
		// save a single Card
		System.out.println(params.get("CardId") + " " +  
				params.get("CardPin") + " " +
				params.get("CardBalance"));
		repository.save(new Card(
				params.get("CardId"), 
				params.get("CardPin"), 
				params.get("CardBalance"))); 
		return "Done";
	}
	
}