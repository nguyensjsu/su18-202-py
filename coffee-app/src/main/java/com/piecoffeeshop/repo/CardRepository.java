package com.piecoffeeshop.repo;

import java.util.List;

import org.socialsignin.spring.data.dynamodb.repository.EnableScan;
import org.springframework.data.repository.CrudRepository;

import com.piecoffeeshop.model.Card;
 
@EnableScan
public interface CardRepository extends CrudRepository<Card, String> {
 
	List<Card> findByCardId(String cardId);
}