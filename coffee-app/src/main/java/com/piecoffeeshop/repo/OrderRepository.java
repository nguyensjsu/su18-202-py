package com.piecoffeeshop.repo;

import java.util.List;

import org.socialsignin.spring.data.dynamodb.repository.EnableScan;
import org.springframework.data.repository.CrudRepository;

import com.piecoffeeshop.model.Order;

@EnableScan
public interface OrderRepository extends CrudRepository<Order, String> {

	//List<Order> findBy(String lastName);
}
