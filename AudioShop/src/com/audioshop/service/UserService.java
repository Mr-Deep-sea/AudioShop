package com.audioshop.service;

import java.util.List;

import com.audioshop.model.User;

public interface UserService extends BaseService<User> {
	public List<User> login(String name, String password,int author);
	public int findUserByName(String name);
	public List<User> findUsersByPhone(String phone);
}
