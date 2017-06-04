package com.audioshop.model;

import java.util.Date;

public class BorrowRecord {
private String id;
private String userId;
private String audioIds;
private String numbers;
private Date borrowDate;
public String getId() {
	return id;
}
public void setId(String id) {
	this.id = id;
}
public String getUserId() {
	return userId;
}
public void setUserId(String userId) {
	this.userId = userId;
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
public Date getBorrowDate() {
	return borrowDate;
}
public void setBorrowDate(Date borrowDate) {
	this.borrowDate = borrowDate;
}


}
