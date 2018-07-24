package com.sjsu.payments;

import java.util.List;

import org.socialsignin.spring.data.dynamodb.repository.EnableScan;
import org.springframework.data.repository.CrudRepository;

@EnableScan
public interface UserDAO extends CrudRepository<User, String> {
	  
  List<User> findByFirstName(String firstName);

}