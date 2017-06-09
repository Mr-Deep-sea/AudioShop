package com.audioshop.model;

public class Audio {
private String id;
private String name;
//类型
private Category category;
//其他项
private String otherItem;
//库存量
private Integer stock;
//预约数量
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

public Category getCategory() {
	return category;
}
public void setCategory(Category category) {
	this.category = category;
}
public String getOtherItem() {
	return otherItem;
}
public void setOtherItem(String otherItem) {
	this.otherItem = otherItem;
}

public Integer getStock() {
	return stock;
}
public void setStock(Integer stock) {
	this.stock = stock;
}
public int getReservation() {
	return reservation;
}
public void setReservation(int reservation) {
	this.reservation = reservation;
}

}
