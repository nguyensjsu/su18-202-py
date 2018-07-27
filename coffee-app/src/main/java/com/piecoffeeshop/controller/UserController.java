package com.piecoffeeshop.controller;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.piecoffeeshop.model.User;
import com.piecoffeeshop.repo.UserRepository;

@RestController
public class UserController {

	@Autowired
	UserRepository repository;

	@RequestMapping("/deleteUsers")
	public String delete() {
		repository.deleteAll();
		return "Deleted All the Users";
	}

	@RequestMapping("/saveUsers")
	public String save() {
		// save a single User
		repository.save(new User("JSA-1", "Jack", "","","",""));

//		// save a list of Customers
//		repository.save(Arrays.asList(new User("JSA-2", "Adam", "","","",""), new User("JSA-3", "Kim", "","","",""),
//				new User("JSA-4", "David", "","","",""), new User("JSA-5", "Peter","","","","")));

		return "Saved Users";
	}

	@RequestMapping("/findallUsers")
	public String findAll() {
		String result = "";
		Iterable<User> users = repository.findAll();

		for (User cust : users) {
			result += cust.toString() + "<br>";
		}

		return result;
	}

	@RequestMapping("/findUserbyid")
	public String findById(@RequestParam("id") String id) {
		String result = "";
		result = repository.findOne(id).toString();
		return result;
	}

	@RequestMapping("/findUserbyname")
	public String fetchDataByName(@RequestParam("name") String name) {
		String result = "";

		for (User cust : repository.findByName(name)) {
			result += cust.toString() + "<br>";
		}

		return result;
	}
}
