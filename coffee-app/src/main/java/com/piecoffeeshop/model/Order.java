package com.piecoffeeshop.model;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAttribute;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBHashKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTable;

/**
 * 
 * @author Abhinaya Yelipeddi
 * This is the Order POJO class to Manage Orders.
 * We have id, OrderName, size, quantity and cost.
 *
 */

@DynamoDBTable(tableName = "Order")
public class Order {

	private String id;
	private String orderName;
	private String size;
	private String quantity;
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
	
	@DynamoDBAttribute(attributeName = "Size")
	public String getSize() {
		return size;
	}

	public void setSize(String size) {
		this.size = size;
	}
	
	@DynamoDBAttribute(attributeName = "Quantity")
	public String getQuantity() {
		return quantity;
	}

	public void setQuantity(String quantity) {
		this.quantity = quantity;
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
		return String.format("Order[Id=%s, OrderName='%s', Size = '%s', Quantity = '%s', Cost='%s']", 
				id, orderName, size, quantity, cost);
	}

}