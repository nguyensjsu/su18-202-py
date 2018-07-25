package com.sjsu.payments;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;





@RestController
@CrossOrigin(origins = "*")
public class PaymentController {


	  @Autowired
	  private PaymentService paymentService;
	  
	  @Autowired
	  private MenuService menuService;
	  
	  @Autowired
	  private UserService userService;
		
	  public double menuCost;
	  public double cardBalance;
	  public double subtractbalancefromMenu;
//	@Autowired
//	private CardRepository cardRepository;
	  
//	  @Autowired
//	private MenuRepository menuRepository;
	  
	  @RequestMapping(method = RequestMethod.GET, value = "/getCard/{cardId}")
	  public ResponseEntity<List<Card>> getCardBalance(@PathVariable String cardId) {
	    List<Card> card = paymentService.getCardBalance(cardId);
	    
	    if(card.isEmpty())
	    	 return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
	    else
	    {
	    	
	    return new ResponseEntity<> (card, HttpStatus.OK);
	    
	    }
	  } 
	  @RequestMapping(method = RequestMethod.POST, value = "/makePayment/{userId}")
	  public ResponseEntity makePayment(@PathVariable String userId) {
		    List<Card> card = paymentService.getCardBalance(userId);
		    
		    if(card.isEmpty())
		    //	 return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
		    	return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body("Card not added by User. Add card to process the payment");
		    else  if( menuCost == 0){
		    	return  ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).body("Select a drink and then Pay");
		    }
		    else
		    {
		    	 String balance = card.get(0).getBalance();
				  cardBalance= Double.parseDouble(balance);
				  System.out.println(" card balance" +  cardBalance  + "   " + "menucost" + menuCost);
				  if(cardBalance >= menuCost) {
				  subtractbalancefromMenu = cardBalance - menuCost;
				  menuCost = 0 ;
				  card.get(0).setBalance(Double.toString(subtractbalancefromMenu));
				  paymentService.updateCardBalance(card.get(0));
				  //paymentService.
				  System.out.println("balance" + subtractbalancefromMenu);
				  return ResponseEntity.status(HttpStatus.ACCEPTED).body("Payment Successful");
				  //return new ResponseEntity<> (card, HttpStatus.OK);
				  }
				  else {
					  System.out.println("insufficient balance to process payment");
					  //return new ResponseEntity<> (null, HttpStatus.EXPECTATION_FAILED);
					  return  ResponseEntity.status(HttpStatus.FORBIDDEN).body("Insufficient Balance in the card to process the payment.Reload the Card with money");
				  }
		    
		    }
		  } 
	
	  @RequestMapping(value="/getMenuCost/findAll")
	  public  List<Menu> findMenuItems() {
		  //List<Menu> menu = menuRepository.findByProdName("ChaiLatte");
		  List<Menu> menu =  menuService.listMenu();//("ChaiLatte");
		
		  return menu; 
	  }
	  
	  @RequestMapping(method = RequestMethod.GET, value="/getCostbyMenu/{menuName}")
	  public  String getCostbyMenuName(@PathVariable String menuName) {
		  //List<Menu> menu = menuRepository.findByProdName("ChaiLatte");
		  List<Menu> menu =  menuService.getCostbyMenuName(menuName);
		  if(menu.isEmpty()) {
			  return "Item not available";
		  }
			 
		  else {
		  String cost = menu.get(0).getCost();
		  menuCost= Double.parseDouble(cost);
		  return cost; 
		  }
	  }
	  
	  
		 /* while(menu.)
		  if(menu.isEmpty())
		    	 return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
		    else
		    return new ResponseEntity<> (menu, HttpStatus.OK);
		  
		  
	  } */
	  
	  
	  @RequestMapping(value = "/list/user")
	  public List<User> listUser() {
	    List<User> list = userService.listUser();
	    return list;
	  }
	  
	  
  /*    @RequestMapping(method = RequestMethod.GET,value="/getItemCost")
	  public List<Menu> getCostbyMenuName(@RequestParam("ProdName") String ProdName) {
		  List<Menu> menu = menuRepository.findByProdName(ProdName);
		  
		    return menu;
		  
	  }*/
	//  @RequestMapping(method = RequestMethod.GET,value ="/getOrder/{orderid}")
	  
}
