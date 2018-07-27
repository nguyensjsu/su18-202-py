package com.piecoffeeshop.controller;

import java.util.Arrays;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
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

	@RequestMapping(value="/saveUsers", method = RequestMethod.POST)
	public String save(@RequestBody Map<String, String > users) {
		System.out.println(users.get("UserId") + ""+
							users.get("Name")+""+
							users.get("CardId")+""+
							users.get("PhoneNo")+""+
							users.get("PaymentOptions")+""+
							users.get("AccessPin"));
		repository.save(new User(
				users.get("UserId"), 
				users.get("Name"), 
				users.get("CardId"),
				users.get("PhoneNo"),
				users.get("PaymentOptions"),
				users.get("AccessPin"))); 
		return "Save Users";
	
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
