package com.piecoffeeshop.model;


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
	private String userId;
	
	private static Random rndm = new Random();
	private static int idRndm;
	
	public Card() {
	}
	
	public Card(String Id, String PIN, String bal, String uId) {
		idRndm = rndm.nextInt(1000) + 1;
		id = (new Integer(idRndm)).toString();
		cardId = Id;
		cardPIN = PIN;
		balance = bal;
		userId = uId;
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
	
	@DynamoDBAttribute(attributeName = "userId")
	public String getUserId() {
		return userId;
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

	public void setUserId(String uId) {
		userId = uId;
	}
	
	@Override
	public String toString() {
		return String.format("Card[id=%s, CardId='%s', CardPIN='%s', CardBalance='%s', UserId='%s']", id, cardId, cardPIN, balance, userId);
	}

}