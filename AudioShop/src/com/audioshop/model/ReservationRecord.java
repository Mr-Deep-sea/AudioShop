package com.audioshop.model;

import java.util.Date;

public class ReservationRecord {
private String userId;
private String audioId;
private int number;
private Date date;
public String getUserId() {
	return userId;
}
public void setUserId(String userId) {
	this.userId = userId;
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
public Date getDate() {
	return date;
}
public void setDate(Date date) {
	this.date = date;
}

}
