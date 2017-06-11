package com.audioshop.action;

import java.util.Date;

import javax.annotation.Resource;

import org.apache.commons.lang3.StringUtils;
import org.apache.struts2.ServletActionContext;

import com.audioshop.common.Msg;
import com.audioshop.model.Audio;
import com.audioshop.model.Order;
import com.audioshop.model.OrderItem;
import com.audioshop.service.AudioService;
import com.audioshop.service.OrderService;
import com.audioshop.util.IDTools;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class OrderAction extends ActionSupport {
	private String audioId;
	private Integer orderItemNumber;
	@Resource
	private OrderService orderService;
	@Resource
	private AudioService audioService;

	public String getAudioId() {
		return audioId;
	}

	public void setAudioId(String audioId) {
		this.audioId = audioId;
	}

	

	
	public Integer getOrderItemNumber() {
		return orderItemNumber;
	}

	public void setOrderItemNumber(Integer orderItemNumber) {
		this.orderItemNumber = orderItemNumber;
	}

	public String addOrderItem() {
		Msg msg = new Msg();
		if(StringUtils.isBlank(audioId)||orderItemNumber==null||orderItemNumber<0
				||orderItemNumber>100){
			msg.setMsg("添加失败！");
			msg.setState(0);
			ServletActionContext.getRequest().setAttribute("msg", msg);
			return "showMsg";
		}
		Order order = this.getOrderCart();
		OrderItem orderItem=new OrderItem();
		orderItem.setNumber(orderItemNumber);
		orderItem.setOrderId(order.getId());
		Audio audio=audioService.findObjectById(audioId);
		if(audio==null){
			msg.setMsg("添加失败！");
			msg.setState(0);
			ServletActionContext.getRequest().setAttribute("msg", msg);
			return "showMsg";
		}
		orderItem.setAudio(audio);
		order.getOrderItems().add(orderItem);
		
		/*for (OrderItem orderItem1: order.getOrderItems()) {
			System.out.println(orderItem1.getNumber());
		}*/
		msg.setMsg("添加订单项成功！");
		msg.setState(0);
	//	ActionContext.getContext().getSession().put("order", order);
		ServletActionContext.getRequest().setAttribute("msg", msg);
		return "showMsg";
	}

	private Order getOrderCart() {
		Order order = (Order) ActionContext.getContext().getSession()
				.get("order");
		if (order == null) {
			order = new Order();
			order.setId(IDTools.getId());
			order.setOrderDate(new Date());
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
			ActionContext.getContext().getSession().put("order", null);
			msg.setMsg("订单提交成功！");
			msg.setState(1);
			msg.setUrl("index.jsp");
			ServletActionContext.getRequest().setAttribute("msg", msg);
			return "showMsg";
		}
	}
}
