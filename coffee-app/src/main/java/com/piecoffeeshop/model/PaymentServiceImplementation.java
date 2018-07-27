package com.piecoffeeshop.model;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.piecoffeeshop.repo.CardRepository;


@Service
public class PaymentServiceImplementation implements PaymentService {

	
	@Autowired
	private CardRepository cardRepository;
	
	@Override
	public  List<Card>  getCardBalance(String cardId) {
		// TODO Auto-generated method stub
		
	  List<Card> cardobj = (List<Card>) cardRepository.findByCardId(cardId);
		return cardobj;
	}

	@Override
	public void updateCardBalance(Card card) {
		// TODO Auto-generated method stub
		cardRepository.save(card);
	}

}
