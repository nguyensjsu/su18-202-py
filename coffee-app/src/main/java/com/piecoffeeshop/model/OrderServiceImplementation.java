package com.piecoffeeshop.model;

/**
 * 
 * @author Abhinaya Yelipeddi
 * This is the Order service implementation to Manage orders.
 * This class implements the getSpecificOrder Method.
 * This method get the ordername from the user entered order
 * and calls the respective coffee class and gets the cost.
 *
 */

public class OrderServiceImplementation implements OrderService{
	
	@Override
	public Order getSpecificOrder(Order order) {
		// TODO Auto-generated method stub
		
		/* If order is Mocha */
		if (order.getOrderName().toString().equals("Mocha")) {
			Mocha m = new Mocha();
			String[] mo = { order.getSize().toString(), order.getQuantity().toString() };
			m.setOptions(mo);
			order.setCost(m.getCost().toString());
		}
		
		/* If order is MasalaChai */
		if (order.getOrderName().toString().equals("MasalaChai")) {
			MasalaChai mc = new MasalaChai();
			String[] mco = { order.getSize().toString(), order.getQuantity().toString() };
			mc.setOptions(mco);
			order.setCost(mc.getCost().toString());
		}
		
		/* If order is Cappuchino */
		if (order.getOrderName().toString().equals("Cappuchino")) {
			Cappuchino c = new Cappuchino();
			System.out.println("cappuchino bef adding cost in web=" + order.getCost());
			String[] co = { order.getSize().toString(), order.getQuantity().toString() };
			c.setOptions(co);
			order.setCost(c.getCost().toString());
			System.out.println("cappuchino after adding cost in web=" + order.getCost());
		}
		
		/* If order is Latte */
		if (order.getOrderName().toString().equals("Latte")) {
			Latte l = new Latte();
			String[] lo = { order.getSize().toString(), order.getQuantity().toString() };
			l.setOptions(lo);
			order.setCost(l.getCost().toString());
			
		}
		return order;
	}
	

}
