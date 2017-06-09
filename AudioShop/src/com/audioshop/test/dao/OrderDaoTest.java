package com.audioshop.test.dao;

import java.util.List;

import com.audioshop.dao.OrderDao;
import com.audioshop.model.Order;
import com.audioshop.model.OrderItem;
import com.audioshop.util.getObjectBySpring;

public class OrderDaoTest {
	public static void main(String[] args) {
		OrderDao orderDao=(OrderDao)getObjectBySpring.getObject("orderDao");
		List<Order> orders;
		orders=orderDao.findObjects();
		for (OrderItem orderItem : orders.get(0).getOrderItems()) {
			System.out.println(orderItem.getAudioId());
		}
	}
}
