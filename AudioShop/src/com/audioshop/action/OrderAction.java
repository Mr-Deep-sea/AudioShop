package com.audioshop.action;

import javax.annotation.Resource;

import org.apache.struts2.ServletActionContext;

import com.audioshop.common.Msg;
import com.audioshop.model.Order;
import com.audioshop.model.OrderItem;
import com.audioshop.service.OrderService;
import com.audioshop.util.IDTools;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class OrderAction extends ActionSupport {
	private OrderItem orderItem;
	@Resource
	private OrderService orderService;
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
		ActionContext.getContext().getSession().put("order", order);
		ServletActionContext.getRequest().setAttribute("msg", msg);
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
	public String commitOrder(){
		Order order=(Order) ActionContext.getContext().getSession()
				.get("order");
		Msg msg=new Msg();
		if (order == null||order.getOrderItems().size()<=0) {
			msg.setMsg("订单提交失败");
			msg.setState(0);
			ServletActionContext.getRequest().setAttribute("msg", msg);
			return "showMsg";
		}else{
			orderService.save(order);
			msg.setMsg("订单提交提交成功！");
			msg.setState(1);
			msg.setUrl("index.jsp");
			ServletActionContext.getRequest().setAttribute("msg", msg);
			return "showMsg";
		}
	}
}
