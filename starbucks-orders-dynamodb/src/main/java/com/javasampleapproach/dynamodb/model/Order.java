package com.javasampleapproach.dynamodb.model;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAttribute;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBHashKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTable;

@DynamoDBTable(tableName = "Order")
public class Order {

	private String id;
	private String orderName;
	private String cost;

	public Order() {
	}

	public Order(String id, String orderName, String cost) {
		this.id = id;
		this.orderName = orderName;
		this.cost = cost;
	}

	@DynamoDBHashKey(attributeName = "Id")
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	@DynamoDBAttribute(attributeName = "OrderName")
	public String getOrderName() {
		return orderName;
	}

	public void setOrderName(String orderName) {
		this.orderName = orderName;
	}

	@DynamoDBAttribute(attributeName = "Cost")
	public String getCost() {
		return cost;
	}

	public void setCost(String cost) {
		this.cost = cost;
	}

	@Override
	public String toString() {
		return String.format("Order[id=%s, orderName='%s', cost='%s']", id, orderName, cost);
	}

}