package com.audioshop.model;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class Order {
private String id;
private Set<OrderItem> orderItems=new HashSet<OrderItem>();
private int state;
private Date orderDate;
public String getId() {
	return id;
}
public void setId(String id) {
	this.id = id;
}

public int getState() {
	return state;
}
public void setState(int state) {
	this.state = state;
}
public Date getOrderDate() {
	return orderDate;
}
public void setOrderDate(Date orderDate) {
	this.orderDate = orderDate;
}
public Set<OrderItem> getOrderItems() {
	return orderItems;
}
public void setOrderItems(Set<OrderItem> orderItems) {
	this.orderItems = orderItems;
}

}
