package com.audioshop.model;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class BorrowRecord {
private String id;
private User user;
private Set<BorrowRecordItem> borrowRecordItems=new HashSet<BorrowRecordItem>();
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
public Set<BorrowRecordItem> getBorrowRecordItems() {
	return borrowRecordItems;
}
public void setBorrowRecordItems(Set<BorrowRecordItem> borrowRecordItems) {
	this.borrowRecordItems = borrowRecordItems;
}
public Date getBorrowDate() {
	return borrowDate;
}
public void setBorrowDate(Date borrowDate) {
	this.borrowDate = borrowDate;
}



}
