package com.audioshop.model;

public class Audio {
private String id;
private String name;
private String categoryId;
private String character;
private int stock;
private int reservation;
public String getId() {
	return id;
}
public void setId(String id) {
	this.id = id;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getCategoryId() {
	return categoryId;
}
public void setCategoryId(String categoryId) {
	this.categoryId = categoryId;
}
public String getCharacter() {
	return character;
}
public void setCharacter(String character) {
	this.character = character;
}
public int getStock() {
	return stock;
}
public void setStock(int stock) {
	this.stock = stock;
}
public int getReservation() {
	return reservation;
}
public void setReservation(int reservation) {
	this.reservation = reservation;
}
 
}
