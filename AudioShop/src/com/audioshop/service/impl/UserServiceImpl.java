package com.audioshop.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.audioshop.dao.UserDao;
import com.audioshop.model.User;
import com.audioshop.service.UserService;


@Service("userService")
public class UserServiceImpl extends BaseServiceImpl<User> implements
		UserService {
	private UserDao userDao;

	@Resource
	public void setUserDao(UserDao userDao) {
		super.setBaseDao(userDao);
		this.userDao = userDao;
	}

	@Override
	public List<User> login(String phone, String password) {
		return userDao.login(phone, password);
	}

	
	@Override
	public List<User> findUsersByPhone(String phone) {
		return userDao.findUsersByPhone(phone);
	}



}
