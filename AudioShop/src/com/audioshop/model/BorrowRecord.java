package com.audioshop.model;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class BorrowRecord {
private String id;
private User user;
/*private String audioId;*/
private Audio audio;

private String number;
private Date borrowDate;
public String getId() {
	return id;
}
public void setId(String id) {
	this.id = id;
}
public User getUser() {
	return user;
}
public void setUser(User user) {
	this.user = user;
}

public Audio getAudio() {
	return audio;
}
public void setAudio(Audio audio) {
	this.audio = audio;
}
public String getNumber() {
	return number;
}
public void setNumber(String number) {
	this.number = number;
}
public Date getBorrowDate() {
	return borrowDate;
}
public void setBorrowDate(Date borrowDate) {
	this.borrowDate = borrowDate;
}



}
