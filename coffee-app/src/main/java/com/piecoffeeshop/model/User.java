package com.piecoffeeshop.model;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAttribute;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBHashKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTable;

@DynamoDBTable(tableName = "User")
public class User {

	private String id;
	private String name;
	private String cardID;
	private String phoneNo;
	private String paymentOptions;
	private String accessPin;
	private String timeStamp;
	private String updateTimeStamp;

	public User() {
	}

	public User(String id, String name, String cardID, String phoneNo, String paymentOptions, String accessPin) {
		this.id = id;
		this.name = name;
		this.cardID = cardID;
		this.phoneNo= phoneNo;
		this.paymentOptions= paymentOptions;
		this.accessPin= accessPin;
	}

	@DynamoDBHashKey(attributeName = "Id")
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	@DynamoDBAttribute(attributeName = "Name")
	public String getName() {
		return name;
	}

	public void setFirstName(String name) {
		this.name = name;
	}

	@DynamoDBAttribute(attributeName = "Card ID")
	public String getCardID() {
		return cardID;
	}

	public void setCardID(String cardID) {
		this.cardID = cardID;
	}

	@DynamoDBAttribute(attributeName = "Phone NO")
	public String getPhoneNo() {
		return phoneNo;
	}

	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}

	@DynamoDBAttribute(attributeName = "Payment Options")
	public String getPaymentOptions() {
		return paymentOptions;
	}

	public void setPaymentOptions(String paymentOptions) {
		this.paymentOptions = paymentOptions;
	}

	@DynamoDBAttribute(attributeName = "Access Pin")
	public String getAccessPin() {
		return accessPin;
	}

	public void setAccessPin(String accessPin) {
		this.accessPin = accessPin;
	}
	

	@Override
	public String toString() {
		return String.format("User[id=%s, Name='%s', CardID='%s', Phone No='%s', Payment Options='%s', Access Pin='%s']", id, name, cardID, phoneNo, paymentOptions, accessPin );
	}

}