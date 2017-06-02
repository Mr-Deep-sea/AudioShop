package com.audioshop.dao;

import java.util.List;

import com.audioshop.model.User;

public interface UserDao extends BaseDao<User> {
	// 根据用户的帐号和密码查询用户列表
	public List<User> login(String phone, String password);
	public List<User> findUsersByPhone(String phone);
}
