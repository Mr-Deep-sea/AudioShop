package com.audioshop.model;

public class BorrowRecordItem {
private String id;
private String borrowRecordId;
private String audioId;
private int number;
public String getId() {
	return id;
}
public void setId(String id) {
	this.id = id;
}

public String getBorrowRecordId() {
	return borrowRecordId;
}
public void setBorrowRecordId(String borrowRecordId) {
	this.borrowRecordId = borrowRecordId;
}
public String getAudioId() {
	return audioId;
}
public void setAudioId(String audioId) {
	this.audioId = audioId;
}
public int getNumber() {
	return number;
}
public void setNumber(int number) {
	this.number = number;
}

}
