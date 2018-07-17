package com.sjsu.reactive;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Order {
	private Integer orderid;
	private String ordername;

	public Order(@JsonProperty("orderid") Integer orderid, @JsonProperty("ordername") String ordername){
		this.orderid = orderid;
		this.ordername = ordername;
	}

	public Integer getOrderid() {
		return orderid;
	}

	public void setOrderid(Integer orderid) {
		this.orderid = orderid;
	}

	public String getOrdername() {
		return ordername;
	}

	public void setOrdername(String ordername) {
		this.ordername = ordername;
	}
}