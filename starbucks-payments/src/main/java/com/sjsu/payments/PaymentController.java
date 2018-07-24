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
		
	
//	@Autowired
//	private CardRepository cardRepository;
	  
//	  @Autowired
//	private MenuRepository menuRepository;
	  
	  @RequestMapping(method = RequestMethod.GET, value = "/getCard/{cardId}")
	  public ResponseEntity<List<Card>> getCard(@PathVariable String cardId) {
	    List<Card> card = paymentService.getCard(cardId);
	    
	    if(card.isEmpty())
	    	 return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
	    else
	    return new ResponseEntity<> (card, HttpStatus.OK);
	  } 
	  
	
	  @RequestMapping(value="/getCost/findAll")
	  public  List<Menu> getCostbyMenuName() {
		  //List<Menu> menu = menuRepository.findByProdName("ChaiLatte");
		  List<Menu> menu =  menuService.listMenu();//("ChaiLatte");
		  return menu; 
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
