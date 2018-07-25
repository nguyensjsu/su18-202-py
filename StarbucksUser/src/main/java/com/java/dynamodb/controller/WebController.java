package com.java.dynamodb.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.java.dynamodb.model.Useers;
import com.java.dynamodb.repo.UsersRepository;

@RestController
public class WebController {

	@Autowired
	UsersRepository repository;

	@RequestMapping("/delete")
	public String delete() {
		repository.deleteAll();
		return "Done";
	}

	@RequestMapping("/save")
	public String save() {
		// save a single Customer
		repository.save(new Useers("1", "Vidhi", "222211113334444"));

		// save a list of Customers
		/*repository.save(Arrays.asList(new Customer("JSA-2", "Adam", "Johnson"), new Customer("JSA-3", "Kim", "Smith"),
				new Customer("JSA-4", "David", "Williams"), new Customer("JSA-5", "Peter", "Davis")));
*/
		return "Done";
	}

	@RequestMapping("/findall")
	public String findAll() {
		String result = "";
		Iterable<Useers> customers = repository.findAll();

		for (Useers cust : customers) {
			result += cust.toString() + "<br>";
		}

		return result;
	}

	@RequestMapping("/findbyid")
	public String findById(@RequestParam("id") String id) {
		String result = "";
		result = repository.findOne(id).toString();
		return result;
	}

	@RequestMapping("/findbyname")
	public String fetchDataByName(@RequestParam("name") String name) {
		String result = "";

		for (Useers cust : repository.findByName(name)) {
			result += cust.toString() + "<br>";
		}

		return result;
	}
}
