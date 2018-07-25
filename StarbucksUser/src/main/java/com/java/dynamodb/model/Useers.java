package com.java.dynamodb.model;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAttribute;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBHashKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTable;

@DynamoDBTable(tableName = "User")
public class Useers {

	private String id;
	private String name;
	private String cardId;

	public Useers() {
	}

	public Useers(String id, String name, String cardId) {
		this.id = id;
		this.name = name;
		this.cardId = cardId;
	}

	@DynamoDBHashKey(attributeName = "User ID")
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	@DynamoDBAttribute(attributeName = "Name")
	public String getFirstName() {
		return name;
	}

	public void setFirstName(String name) {
		this.name = name;
	}

	@DynamoDBAttribute(attributeName = "Card ID")
	public String getCardId() {
		return cardId;
	}

	public void setLastName(String cardId) {
		this.cardId = cardId;
	}

	@Override
	public String toString() {
		return String.format("Customer[id=%s, Name='%s', CardId='%s']", id, name, cardId);
	}

}