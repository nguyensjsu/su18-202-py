package com.sjsu.payments;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;




@RestController
public class PaymentController {

	
	  @Autowired
	  private PaymentService paymentService;
	  
	  
	  @RequestMapping(value = "/getCard")
	  public List<Card> getCard() {
	    List<Card> list = paymentService.getCard();
	    return list;
	  }
	  
	  
}
