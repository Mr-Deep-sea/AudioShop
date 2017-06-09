package com.audioshop.model;

public class OrderItem {
private String id;
private String orderId;
private String audioId;
private Integer number;
public String getId() {
	return id;
}
public void setId(String id) {
	this.id = id;
}
public String getOrderId() {
	return orderId;
}
public void setOrderId(String orderId) {
	this.orderId = orderId;
}
public String getAudioId() {
	return audioId;
}
public void setAudioId(String audioId) {
	this.audioId = audioId;
}
public Integer getNumber() {
	return number;
}
public void setNumber(Integer number) {
	this.number = number;
}

}
