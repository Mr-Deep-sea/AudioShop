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
