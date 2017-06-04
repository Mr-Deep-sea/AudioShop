package com.audioshop.model;

import java.util.Date;

public class Order {
private String id;
private String audioIds;
private String numbers;
private int state;
private Date orderDate;
public String getId() {
	return id;
}
public void setId(String id) {
	this.id = id;
}
public String getAudioIds() {
	return audioIds;
}
public void setAudioIds(String audioIds) {
	this.audioIds = audioIds;
}
public String getNumbers() {
	return numbers;
}
public void setNumbers(String numbers) {
	this.numbers = numbers;
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

}
