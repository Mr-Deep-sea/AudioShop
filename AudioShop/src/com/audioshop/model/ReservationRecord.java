package com.audioshop.model;

import java.util.Date;
/**
 * 
 * @author yangy
 *预约记录表
 */
public class ReservationRecord {
private String id;
private String userId;
//预约的资料Ids
private String audioIds;
//预约资料的数量以下标对应
private String numbers;
private Date date;
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
public Date getDate() {
	return date;
}
public void setDate(Date date) {
	this.date = date;
}


}
