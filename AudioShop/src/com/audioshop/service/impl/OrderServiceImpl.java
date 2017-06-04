package com.audioshop.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.audioshop.dao.AudioDao;
import com.audioshop.dao.OrderDao;
import com.audioshop.model.Order;
import com.audioshop.service.OrderService;

@Service("orderService")
public class OrderServiceImpl extends BaseServiceImpl<Order> implements OrderService{

	private OrderDao orderDao;
	
	@Resource
	public void setOrderDao(OrderDao orderDao) {
		super.setBaseDao(orderDao);
		this.orderDao = orderDao;
	}
}
