package com.audioshop.action;

import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.commons.lang3.StringUtils;
import org.apache.struts2.ServletActionContext;

import com.audioshop.common.Msg;
import com.audioshop.model.Audio;
import com.audioshop.model.Order;
import com.audioshop.model.OrderItem;
import com.audioshop.model.ReservationRecord;
import com.audioshop.service.AudioService;
import com.audioshop.service.OrderService;
import com.audioshop.util.IDTools;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class OrderAction extends ActionSupport {
	private Integer audioId;
	private Integer orderItemNumber;
	private String orderId;
	
	public String getOrderId() {
		return orderId;
	}

	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}
	@Resource
	private OrderService orderService;
	@Resource
	private AudioService audioService;



	

	
	public Integer getAudioId() {
		return audioId;
	}

	public void setAudioId(Integer audioId) {
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
		if(audioId==null||orderItemNumber==null||orderItemNumber<0
				||orderItemNumber>100){
			msg.setMsg("添加失败！");
			msg.setState(0);
			ServletActionContext.getRequest().setAttribute("msg", msg);
			return "showMsg";
		}
		
		Map<String, OrderItem> orderItems=this.getOrderItem();
		Order order=this.getSessionOrder();
		
		
	
		Audio audio=audioService.findObjectById(audioId);
		if(audio==null){
			msg.setMsg("添加失败！");
			msg.setState(0);
			ServletActionContext.getRequest().setAttribute("msg", msg);
			return "showMsg";
		}
		if(orderItems.containsKey(audio.getId()+"")){
			OrderItem orderItem1=orderItems.get(audio.getId()+"");
			orderItem1.setNumber(orderItem1.getNumber()+orderItemNumber);
			orderItems.put(audio.getId()+"", orderItem1);
		}else{
			OrderItem orderItem=new OrderItem();
			orderItem.setNumber(orderItemNumber);
			orderItem.setAudio(audio);
			orderItem.setOrderId(order.getId());
			orderItems.put(audio.getId()+"", orderItem);
		}
		
		msg.setMsg("添加订单项成功！");
		msg.setState(0);
	
		ServletActionContext.getRequest().setAttribute("msg", msg);
		return "showMsg";
	}

	private Map<String, OrderItem> getOrderItem() {
		
		Map<String, OrderItem> orderItems=(Map<String, OrderItem>) ActionContext.getContext().getSession()
				.get("orderItems");
		if(orderItems==null){
			orderItems=new HashMap<String, OrderItem>();
			ActionContext.getContext().getSession().put("orderItems", orderItems);
		}
		return orderItems;
	}
	private Order getSessionOrder(){
		Order order=(Order)ActionContext.getContext().getSession().get("sessionOrder");
		if(order==null){
			order=new Order();
			order.setId(IDTools.getId());
			order.setOrderDate(new Date());
			ActionContext.getContext().getSession().put("sessionOrder", order);
		}
		return order;
	}
	public String commitOrder(){
		
		Map<String, OrderItem> orderItems=(Map<String, OrderItem>) ActionContext.getContext().getSession()
				.get("orderItems");
		Msg msg=new Msg();
		if (orderItems == null||orderItems.size()<=0) {
			msg.setMsg("订单提交失败");
			msg.setState(0);
			ServletActionContext.getRequest().setAttribute("msg", msg);
			return "showMsg";
		}else{
			Order order=(Order)ActionContext.getContext().getSession().get("sessionOrder");
			if(order==null){
				msg.setMsg("订单提交失败");
				msg.setState(0);
				ServletActionContext.getRequest().setAttribute("msg", msg);
				return "showMsg";
			}
			Iterator<Map.Entry<String, OrderItem>> iterator=orderItems.entrySet().iterator();
			while (iterator.hasNext()){
				Map.Entry<String, OrderItem> entry=(Map.Entry<String, OrderItem>)iterator.next();
				OrderItem orderItem=entry.getValue();
				order.getOrderItems().add(orderItem);
				}
			orderService.save(order);
			ActionContext.getContext().getSession().put("sessionOrder", null);
			ActionContext.getContext().getSession().put("orderItems", null);
			msg.setMsg("订单提交成功！");
			msg.setState(1);
			msg.setUrl("order_allOrder.action");
			ServletActionContext.getRequest().setAttribute("msg", msg);
			return "showMsg";
		}
	}
	public String currentOrder() {

		Order order = (Order) ActionContext.getContext().getSession()
				.get("sessionOrder");
		Map<String, OrderItem> orderItems=(Map<String, OrderItem>) ActionContext.getContext().getSession()
				.get("orderItems");
		Msg msg = new Msg();
		if (order == null || orderItems==null||orderItems.size() <= 0) {
			msg.setMsg("当前没有订单项,请先添加订单项");
			msg.setState(0);
			ServletActionContext.getRequest().setAttribute("msg", msg);
			return "showMsg";
		} else {
			
			ServletActionContext.getRequest().setAttribute("orderItems",
					orderItems);
			return "currentOrder";
		}

	}
	public String allOrder(){
		List<Order> orders=orderService.findObjects();
		if(orders.size()<=0){
			Msg msg=new Msg();
			msg.setState(0);
			msg.setMsg("没有订单");
			ServletActionContext.getRequest().setAttribute("msg", msg);
			return "showMsg";
			
		}else{
			ServletActionContext.getRequest().setAttribute("allOrder",
					orders);
			return "allOrder";
		}
	}
	public String orderDetail(){
		Msg msg=new Msg();
		if(StringUtils.isBlank(orderId)){
			msg.setState(0);
			msg.setMsg("没有该订单");
			ServletActionContext.getRequest().setAttribute("msg", msg);
			return "showMsg";
		}
		Order order=orderService.findObjectById(orderId);
		if(order!=null){
			ServletActionContext.getRequest().setAttribute("orderDetail", order);
			return "orderDetail";
		}else{
			msg.setState(0);
			msg.setMsg("没有该订单");
			ServletActionContext.getRequest().setAttribute("msg", msg);
			return "showMsg";
		}
		
	}
	public String finishOrder(){
		Msg msg=new Msg();
		if(StringUtils.isBlank(orderId)){
			msg.setState(0);
			msg.setMsg("没有该订单");
			ServletActionContext.getRequest().setAttribute("msg", msg);
			return "showMsg";
		}
		Order order=orderService.findObjectById(orderId);
		if(order!=null){
			if(order.getState()==1){
				msg.setState(0);
				msg.setMsg("该订单已完成");
				ServletActionContext.getRequest().setAttribute("msg", msg);
				return "showMsg";
			}
			for(OrderItem orderItem: order.getOrderItems()) {
				Audio audio1=orderItem.getAudio();
				audio1.setStock(audio1.getStock()+orderItem.getNumber());
				audioService.update(audio1);
			}
			order.setState(1);
			orderService.update(order);
			msg.setMsg("操作成功！");
			msg.setState(1);
			msg.setUrl("order_allOrder.action");
			ServletActionContext.getRequest().setAttribute("msg", msg);
			return "showMsg";
		}else{
			msg.setState(0);
			msg.setMsg("没有该订单");
			ServletActionContext.getRequest().setAttribute("msg", msg);
			return "showMsg";
		}
	}
}
