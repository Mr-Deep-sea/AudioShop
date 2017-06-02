package com.audioshop.service;

import java.util.List;

import com.audioshop.model.User;

public interface UserService extends BaseService<User> {
	public List<User> login(String phone, String password);

	public List<User> findUsersByPhone(String phone);
}
