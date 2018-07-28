package com.piecoffeeshop.model;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAttribute;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBHashKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTable;

@DynamoDBTable(tableName = "Users")
public class User {

	private String UserId;
	private String AccessPin;
	private String CardId;
	private String PaymentOptions;
	private String PhoneNo;
	private String name;
	
	public User() {
	}

	public User(String id, String accessPin, String cardId, String paymentOptions, String phoneNo,String name ) {
		this.UserId = id;
		this.AccessPin = accessPin;
		this.CardId=cardId;
		this.PaymentOptions=paymentOptions;
		this.PhoneNo=phoneNo;
		this.name = name;
	}

	@DynamoDBHashKey(attributeName = "UserId")
	public String getUserId() {
		return UserId;
	}

	public void setUserId(String id) {
		this.UserId = id;
	}

	@DynamoDBAttribute(attributeName = "AccessPin")
	public String getAccessPin() {
		return AccessPin;
	}

	public void setAccessPin(String accessPin) {
		this.AccessPin = accessPin;
	}
	
	@DynamoDBAttribute(attributeName = "CardId")
	public String getCardId() {
		return CardId;
	}

	public void setCardId(String cardId) {
		this.CardId = cardId;
	}
	
	@DynamoDBAttribute(attributeName = "PaymentOptions")
	public String getPaymentOptions() {
		return PaymentOptions;
	}

	public void setPaymentOptions(String payment) {
		this.PaymentOptions = payment;
	}
	
	@DynamoDBAttribute(attributeName = "PhoneNo")
	public String getPhoneNo() {
		return PhoneNo;
	}

	public void setPhoneNo(String phoneNo) {
		this.PhoneNo = phoneNo;
	}
	
	@DynamoDBAttribute(attributeName = "UserName")
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return String.format("User[id=%s, AccessPin='%s', CardId='%s', PaymentOptions='%s', PhoneNo='%s', name='%s']", UserId, name, AccessPin, CardId,PaymentOptions, PhoneNo);
	}

}