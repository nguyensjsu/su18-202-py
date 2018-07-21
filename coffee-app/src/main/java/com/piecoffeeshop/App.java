package com.piecoffeeshop;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	AddCard ac = new AddCard("4123512361237123","999",20.0);
        System.out.println( "AddCard: " + ac.getCardId() );
    }
}
