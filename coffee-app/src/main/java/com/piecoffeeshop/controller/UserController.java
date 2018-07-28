package com.piecoffeeshop.controller;

import java.util.Arrays;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.piecoffeeshop.model.User;
import com.piecoffeeshop.repo.UserRepository;

@Controller
@RestController
public class UserController {

	@Autowired
	UserRepository repository;

	@RequestMapping("/deleteUser")
	public String delete() {
		repository.deleteAll();
		return "Done Deleting all users";
	}

	@RequestMapping(value="/saveUser", method= RequestMethod.POST)
	public String save(@RequestBody Map<String, String> params) {
		
		// save a single User
		/*repository.save(new User("2", "Yamini", "12231", "1231313", "Starbucks Card","13123123123"));

		// save a list of Customers
		repository.save(Arrays.asList(new User("3", "Adam", "Johnson", "", "",""), new User("4", "Kim", "Smith", "", "",""),
				new User("5", "David", "Williams", "", "",""), new User("6", "Peter", "Davis", "", "","")));

			*/
		
		/*{
	"User ID": "3",
	"UserName" :"Gyanesh",
	"AccessPin" : "123",
	"CardId" : "678242342345",
	"PaymentOptions" : "Starbuck Card",
	"PhoneNo" : "113331233"
		}*/
		System.out.println(
				params.get("UserId") + " " +  
				
				params.get("AccessPin") + " " + params.get("CardId")+""+params.get("PaymentOptions") + " " + params.get("PhoneNo")+""+params.get("Username") );
		repository.save(new User(
				params.get("UserId"), 
				params.get("AccessPin"),
				params.get("CardId"),
				params.get("PaymentOptions"),
				params.get("PhoneNo"),
				params.get("UserName"))); 
		return "Done saving new users";
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

	@RequestMapping("/findbyidUser")
	public String findById(@RequestParam("UserId") String id) {
		String result = "";
		result = repository.findOne(id).toString();
		return result;
	}

	@RequestMapping("/findbyName")
	public String fetchDataByName(@RequestParam("name") String name) {
		String result = "";

		for (User cust : repository.findByName(name)) {
			result += cust.toString() + "<br>";
		}

		return result;
	}
}
