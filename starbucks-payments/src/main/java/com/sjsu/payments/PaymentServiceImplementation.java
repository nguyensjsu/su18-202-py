package com.sjsu.payments;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



@Service
public class PaymentServiceImplementation implements PaymentService {

	
	@Autowired
	private CardRepository cardRepository;
	
	@Override
	public  List<Card>  getCardBalance(String userId) {
		// TODO Auto-generated method stub
		
	  List<Card> cardobj = (List<Card>) cardRepository.findByuserId(userId);
		return cardobj;
	}

	@Override
	public void updateCardBalance(Card card) {
		// TODO Auto-generated method stub
		cardRepository.save(card);
	}

}
