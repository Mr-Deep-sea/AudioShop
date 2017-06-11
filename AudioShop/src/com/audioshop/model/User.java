package com.audioshop.model;

public class User {
private Integer id;
private String name;
private String phone;
private String password;
private int author;


public int getAuthor() {
	return author;
}
public void setAuthor(int author) {
	this.author = author;
}

public Integer getId() {
	return id;
}
public void setId(Integer id) {
	this.id = id;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getPhone() {
	return phone;
}
public void setPhone(String phone) {
	this.phone = phone;
}
public String getPassword() {
	return password;
}
public void setPassword(String password) {
	this.password = password;
}



}
