package com.audioshop.dao.impl;

import java.util.List;

import org.hibernate.Query;

import com.audioshop.dao.UserDao;
import com.audioshop.model.User;

public class UserDaoImpl extends BaseDaoImpl<User> implements UserDao {

	@Override
	public List<User> login(String phone, String password) {
		Query query = getSession().createQuery(
				"FROM User WHERE phone=? AND password=?");
		query.setParameter(0, phone);
		query.setParameter(1, password);
		return query.list();
	}

	@Override
	public List<User> findUsersByPhone(String phone) {
		return null;
	}
}