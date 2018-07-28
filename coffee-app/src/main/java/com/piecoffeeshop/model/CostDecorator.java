package com.piecoffeeshop.model;


/**
 * 
 * @author Abhinaya Yelipeddi
 * CostDecorator interface is implemented by all coffee classes
 * (Cappuchino, Mocha, MasalaChai etc)
 *
 */

public interface CostDecorator {
	Double getCost();
	void setOptions(String[] options);
}