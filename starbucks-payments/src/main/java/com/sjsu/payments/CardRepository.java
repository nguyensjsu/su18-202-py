package com.sjsu.payments;

import java.util.List;

import org.socialsignin.spring.data.dynamodb.repository.EnableScan;
import org.springframework.data.repository.CrudRepository;


@EnableScan
public interface CardRepository extends CrudRepository<Card, String> {

	 public List<Card> findBycardId(String cardId);
	 public List<Card> findByuserId(String userId);
	 
}
