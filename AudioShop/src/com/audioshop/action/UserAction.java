package com.audioshop.action;

import com.audioshop.model.User;
import com.opensymphony.xwork2.ActionSupport;

public class UserAction extends ActionSupport{
private User user;

public User getUser() {
	return user;
}

public void setUser(User user) {
	this.user = user;
}

}
