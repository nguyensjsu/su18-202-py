package com.piecoffee;


import java.util.Random;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAttribute;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBHashKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTable;
 
@DynamoDBTable(tableName = "Card")
public class Card {
	private String id;
	private String cardId;
	private String cardPIN;
	private String balance;
	
	private static Random rndm = new Random();
	private static int idRndm;
	
	public Card() {
	}
	
	public Card(String Id, String PIN, String bal) {
		idRndm = rndm.nextInt(1000) + 1;
		id = (new Integer(idRndm)).toString();
		cardId = Id;
		cardPIN = PIN;
		balance = bal;
	}
	
	@DynamoDBHashKey(attributeName = "Id")
	public String getId() {
		return id;
	}

	
	@DynamoDBAttribute(attributeName = "CardId")
	public String getCardId() {
		return cardId;
	}
	
	@DynamoDBAttribute(attributeName = "CardPin")
	public String getCardPin() {
		return cardPIN;
	}
	
	@DynamoDBAttribute(attributeName = "CardBalance")
	public String getBalance() {
		return balance;
	}
	
	public void setId(String i) {
		id = i;
	}
	
	public void setCardId(String id) {
		cardId = id;
	}
	
	public void setCardPin(String pin) {
		cardPIN = pin;
	}
	
	public void setBalance(String bal) {
		balance = bal;
	}
	
	@Override
	public String toString() {
		return String.format("Card[id=%s, CardId='%s', CardPIN='%s', CardBalance='%s']", id, cardId, cardPIN, balance);
	}

}