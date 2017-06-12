package com.audioshop.dao.impl;

import java.util.List;

import org.hibernate.Query;

import com.audioshop.dao.UserDao;
import com.audioshop.model.User;

public class UserDaoImpl extends BaseDaoImpl<User> implements UserDao {

	@Override
	public List<User> login(String name, String password,int author) {
		Query query = getSession().createQuery(
				"FROM User WHERE name=? AND password=? AND author=?");
		query.setParameter(0, name);
		query.setParameter(1, password);
		query.setParameter(2, author);
		return query.list();
	}

	@Override
	public List<User> findUsersByPhone(String phone) {
		return null;
	}
	
	@Override
	public int findUserByName(String name) {
		// TODO Auto-generated method stub
		Query query = getSession().createQuery("from User where name=?");
		query.setParameter(0, name);
		List list = query.list();
		if (list.size() != 0) {
			return 1;
		}
		return 0;
	}
}