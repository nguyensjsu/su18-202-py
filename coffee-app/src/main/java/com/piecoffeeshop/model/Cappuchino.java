package com.piecoffeeshop.model;

/**
 * 
 * @author Abhinaya Yelipeddi
 * This is class for Cappuchino Coffee
 *
 */


public class Cappuchino implements CostDecorator {
	private String[] options;
	private Double cost = 0.0;

	

	public void setOptions(String[] options) {
		this.options = options;
		if ("Small".equals(options[0])) {
			this.cost +=4.00;
			
		}
		
		if ("Medium".equals(options[0])) {
			System.out.println(" medium bef assigning cost=" + cost.toString());
			this.cost +=5.00;
			System.out.println("get cost medium=" + cost.toString());
			
		}
		
		if ("Large".equals(options[0])) {
			this.cost +=6.00;
			
		}
		
		if ((options[1]) != null) {
			System.out.println("Inside options not null option[1]=" + options[1]);
			this.cost *= Double.parseDouble(options[1]);
			
		}
		
	}

	public Double getCost() {
		System.out.println("get cost in cappuchino=" + cost.toString());
		return cost;
		
	}
}