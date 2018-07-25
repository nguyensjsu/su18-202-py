package com.javasampleapproach.dynamodb.repo;

import java.util.List;

import org.socialsignin.spring.data.dynamodb.repository.EnableScan;
import org.springframework.data.repository.CrudRepository;

import com.javasampleapproach.dynamodb.model.Order;

@EnableScan
public interface OrderRepository extends CrudRepository<Order, String> {

	//List<Order> findBy(String lastName);
}
