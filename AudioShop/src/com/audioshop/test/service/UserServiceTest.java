package com.audioshop.test.service;

import java.util.List;

import com.audioshop.dao.BorrowRecordDao;
import com.audioshop.model.BorrowRecord;
import com.audioshop.model.User;
import com.audioshop.service.UserService;
import com.audioshop.util.getObjectBySpring;

public class UserServiceTest {
	public static void main(String[] args) {
		UserService userService=(UserService)getObjectBySpring.getObject("userService");
		User user=new User();
		user.setAuthor(1);
		user.setName("hello");
		user.setPassword("6464");
		user.setPhone("4646");
		userService.save(user);
	}

}
