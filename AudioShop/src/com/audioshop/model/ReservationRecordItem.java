package com.audioshop.model;

public class ReservationRecordItem {
private String id;
private String reservationrecordId;
private String audioId;
private int number;
public String getId() {
	return id;
}
public void setId(String id) {
	this.id = id;
}

public String getReservationrecordId() {
	return reservationrecordId;
}
public void setReservationrecordId(String reservationrecordId) {
	this.reservationrecordId = reservationrecordId;
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
