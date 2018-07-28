package com.piecoffeeshop.controller;

import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.piecoffeeshop.model.Card;
import com.piecoffeeshop.model.Greeting;
import com.piecoffeeshop.repo.CardRepository;

@RestController
public class CardController{
	
	@Autowired
	CardRepository repository;
			
	private static final String template = "Hello, %s!";
	private final AtomicLong counter = new AtomicLong(); 

	private Card cc = new Card("1234567887654321","9876","51.00","999");

	@RequestMapping("/greeting")
	public Greeting greeting(@RequestParam(value="name", defaultValue="World") String name){
		return new Greeting(counter.incrementAndGet(), String.format(template, name));
	}

	@RequestMapping("/getBalance")
	public Card getBalance(@RequestParam(value="cardNum", defaultValue="1234567887654321") String cardNum){
		return cc;
	}
	
	@RequestMapping("/findallcards")
	public String findAll() {
		String result = "";
		Iterable<Card> cards = repository.findAll();
 
		for (Card cust : cards) {
			result += cust.toString() + "<br>";
		}
 
		return result;
	}
	
	@RequestMapping("/deleteallcards")
	public String delete() {
		repository.deleteAll();
		return "Done";
	}
	
	/*
	 * Sample Request Body
	 * {
		"CardId":"1234432167899879",
		"CardPin":"1234",
		"CardBalance":"22.00",
		"userId":"987"
		}
	 * */
	
	@RequestMapping(value = "/savecard", method = RequestMethod.POST)
	public ResponseEntity save(@RequestBody Map<String, String> params) {
		// save a single Card
		System.out.println(params.get("CardId") + " " +  
				params.get("CardPin") + " " +
				params.get("CardBalance") + " " + params.get("userId") );

		String cardId = params.get("CardId");
		String cardPin = params.get("CardPin");
		
		if (!isValidCardId(cardId)) {
			  return  ResponseEntity.status(HttpStatus.FORBIDDEN).body("Incorrect Card/Pin format.");						
		}

		if (!isValidCardPin(cardPin)) {
			  return  ResponseEntity.status(HttpStatus.FORBIDDEN).body("Incorrect Card/Pin format.");						
		}
		
		repository.save(new Card(
				params.get("CardId"), 
				params.get("CardPin"), 
				params.get("CardBalance"),
				params.get("userId"))); 
		
		return ResponseEntity.status(HttpStatus.ACCEPTED).body("Card added successfully.");
	}
	
	public boolean isValidCardId(String cardId) {
		if (cardId.length() == 16) {
			return true;
		}
		return false;
	}

	public boolean isValidCardPin(String cardPin) {
		if (cardPin.length() == 4) {
			return true;
		}
		return false;
	}
	
}