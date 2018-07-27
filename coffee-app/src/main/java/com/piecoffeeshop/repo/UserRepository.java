package com.piecoffeeshop.repo;

import java.util.List;

import org.socialsignin.spring.data.dynamodb.repository.EnableScan;
import org.springframework.data.repository.CrudRepository;

import com.piecoffeeshop.model.User;

@EnableScan
public interface UserRepository extends CrudRepository<User, String> {

	List<User> findByName(String name);
}
