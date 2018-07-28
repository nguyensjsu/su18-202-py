package com.piecoffeeshop.model;

/**
 * 
 * @author Abhinaya Yelipeddi
 * This is class for MasalaChai Coffee
 *
 */



public class MasalaChai implements CostDecorator {
	private String[] options;
	private Double cost = 0.0;

	

	public void setOptions(String[] options) {
		this.options = options;
		if ("Small".equals(options[0])) {
			this.cost +=1.00;
			
		}
		
		if ("Medium".equals(options[0])) {
			this.cost +=1.50;
			
		}
		
		if ("Large".equals(options[0])) {
			this.cost +=2.00;
			
		}
		
		if ((options[1]) != null) {
			this.cost *= Double.parseDouble(options[1]);
			
		}
		
	}

	public Double getCost() {
		return cost;
		
	}
}
