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
private Set<ReservationRecordItem> reservationRecordItems= new HashSet<ReservationRecordItem>();;
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
public Set<ReservationRecordItem> getReservationRecordItems() {
	return reservationRecordItems;
}
public void setReservationRecordItems(
		Set<ReservationRecordItem> reservationRecordItems) {
	this.reservationRecordItems = reservationRecordItems;
}
public Date getDate() {
	return date;
}
public void setDate(Date date) {
	this.date = date;
}


}
