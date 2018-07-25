package com.javasampleapproach.dynamodb.controller;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.javasampleapproach.dynamodb.model.Order;
import com.javasampleapproach.dynamodb.repo.OrderRepository;

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
        // save a single Order
        //repository.save(new Order("1", "Cappuchino", "2.50"));
        
        /* saving an order list */
        //repository.save(Arrays.asList(new Order("2", "Latte", "3.50"), new Order("3", "Chai", "1.50")));
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
