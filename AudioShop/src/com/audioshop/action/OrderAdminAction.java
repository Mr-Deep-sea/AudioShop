package com.audioshop.action;

import com.audioshop.common.Msg;
import com.audioshop.model.Order;
import com.audioshop.model.OrderItem;
import com.audioshop.util.IDTools;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class OrderAdminAction extends ActionSupport {
	private OrderItem orderItem;

	public OrderItem getOrderItem() {
		return orderItem;
	}

	public void setOrderItem(OrderItem orderItem) {
		this.orderItem = orderItem;
	}

	public String addOrderItem() {

		Order order = this.getOrderCart();
		order.getOrderItems().add(orderItem);
		Msg msg = new Msg();
		msg.setMsg("添加订单项成功！");
		msg.setState(0);
		return "showMsg";
	}

	private Order getOrderCart() {
		Order order = (Order) ActionContext.getContext().getSession()
				.get("order");
		if (order == null) {
			order = new Order();
			order.setId(IDTools.getId());
			order.getOrderItems().add(orderItem);
			ActionContext.getContext().getSession().put("order", order);
		}
		return order;
	}
}
