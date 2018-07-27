package com.piecoffeeshop.model;



public class MasalaChai implements CostDecorator {
	private String[] options;
	private Double cost = 0.0;

	

	public void setOptions(String[] options) {
		this.options = options;
		if ("Small".equals(options[0])) {
			this.cost +=3.00;
			
		}
		
		if ("Medium".equals(options[0])) {
			this.cost +=4.00;
			
		}
		
		if ("Large".equals(options[0])) {
			this.cost +=5.00;
			
		}
		
		if ((options[1]) != null) {
			this.cost *= Double.parseDouble(options[1]);
			
		}
		
	}

	public Double getCost() {
		return cost;
		
	}
}
