package com.sjsu.payments;

import java.util.List;

public interface PaymentService {

	 public List<Card> getCardBalance(String cardId);
	 
	 public void updateCardBalance(Card card);
}
