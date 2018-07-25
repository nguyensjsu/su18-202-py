package com.piecoffee;

import java.util.Arrays;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

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
	
	@RequestMapping("/save")
	public String save() {
		// save a single Customer
		repository.save(new Card("1234567898765432", "1234", "21.00"));
 
		// save a list of Customers
		repository.save(Arrays.asList(new Card("1234567898765433", "1234", "21.00"), new Card("1234567898765434", "1234", "21.00"),
				new Card("1234567898765435", "1234", "21.00"), new Card("1234567898765436", "1234", "21.00")));
 
		return "Done";
	}
	
	@RequestMapping("/savecard")
	public String saveCard() {
		// save a single Customer
		repository.save(new Card("1234567898765432", "1234", "21.00"));
 
		return "Done";
	}
	
}