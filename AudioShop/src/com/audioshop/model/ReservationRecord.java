package com.audioshop.model;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * 
 * @author yangy
 *预约记录表
 */
public class ReservationRecord {
private String id;
private User user;
private Audio audio;
private Date date;
private Integer user_id;
private Integer audio_id;
public Integer getAudio_id() {
	return audio_id;
}
public void setAudio_id(Integer audio_id) {
	this.audio_id = audio_id;
}
public Integer getUser_id() {
	return user_id;
}
public void setUser_id(Integer user_id) {
	this.user_id = user_id;
}
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
public Date getDate() {
	return date;
}
public void setDate(Date date) {
	this.date = date;
}


}
