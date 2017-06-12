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
	public List<User> login(String name, String password,int author) {
		return userDao.login(name, password, author);
	}
	
	@Override
	public List<User> findUsersByPhone(String phone) {
		return userDao.findUsersByPhone(phone);
	}

	@Override
	public int findUserByName(String name) {
		// TODO Auto-generated method stub
		return userDao.findUserByName(name);
	}

}
