package com.audioshop.action;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.commons.lang3.StringUtils;
import org.apache.struts2.ServletActionContext;

import com.audioshop.common.Msg;
import com.audioshop.model.User;
import com.audioshop.service.UserService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class UserAction extends ActionSupport {
	@Resource
	private UserService userService;
	
	private String repass;
	private User user;

	public UserService getUserService() {
		return userService;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	public String getRepass() {
		return repass;
	}
	public void setRepass(String repass) {
		this.repass = repass;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}

	public String toadd(){
		return "addWorker";
	}
	
	public String addWorker() {

		User user1 = new User();
		String repassString;

		user1.setName(user.getName());
		user1.setPassword(user.getPassword());
		user1.setPhone(user.getPhone());
		repassString = this.getRepass();

		Msg msg=new Msg();
		
		if (user1.getPassword().equals(repassString)) {
			int check = userService.findUserByName(user1.getName());
			if (check == 1) {
				msg.setMsg("用户已存在，添加失败！");
				msg.setState(0);
				ServletActionContext.getRequest().setAttribute("msg", msg);
				return "showMsg";
			} else if (check == 0) {
				user1.setAuthor(2);
				userService.save(user1);
				return allWorker();
			}
		}
		msg.setMsg("两次密码不一致，添加失败！");
		msg.setState(0);
		ServletActionContext.getRequest().setAttribute("msg", msg);
		return "showMsg";

	}

	public String deleteWorker() {

		String id=ServletActionContext.getRequest().getParameter("id");

		int idInt = Integer.parseInt(id);
		
		userService.delete(idInt);

		return allWorker();

	}

	public String allWorker() {
		List userList1 = userService.findObjects();
		List<User> userList = new ArrayList<User>();

		if (userList1 != null) {

			Iterator<User> iterator = userList1.iterator();
			while (iterator.hasNext()) {
				User user = new User();
				user = iterator.next();
				if (user.getAuthor() == 2) {
					userList.add(user);
				}
			}

			Map session = (Map) ActionContext.getContext().getSession();

			session.put("userList", userList);

			return "FINDSUCCESS";
		} else {
			return "FINDERROR";
		}

	}

	public String toAddVip(){
		return "addVip";
	}
	
	public String addVip(){
		Msg msg=new Msg();
		User user1=new User();
		
		user1.setName(user.getName());
		user1.setPassword(user.getPassword());
		user1.setPhone(user.getPhone());
		user1.setAuthor(1);
		
		int existUsers=userService.findUserByName(user1.getName());
		
		if(existUsers==0){
			userService.save(user1);
		}
		else {
			msg.setMsg("用户已存在，添加失败！");
			msg.setState(0);
			ServletActionContext.getRequest().setAttribute("msg", msg);
			return "showMsg";
		}
		msg.setMsg("添加成功！");
		msg.setState(1);
		msg.setUrl("worker_toAddVip.action");
		ServletActionContext.getRequest().setAttribute("msg", msg);
		return "showMsg";
	}
	public String login() {
		Msg msg = new Msg();
		if (StringUtils.isBlank(user.getName())
				|| StringUtils.isBlank(user.getPassword()) || user.getAuthor() == 0) {
			msg.setMsg("用户名或密码错误！");
			msg.setState(0);
			ServletActionContext.getRequest().setAttribute("msg", msg);
			return "showMsg";
		}
		List<User> users = userService.login(user.getName(),
				user.getPassword(), user.getAuthor());
		if (users.size() <= 0) {
			msg.setMsg("用户名或密码错误！");
			msg.setState(0);
			ServletActionContext.getRequest().setAttribute("msg", msg);
			return "showMsg";
		}
		User user1=users.get(0);
		user1.setPassword("");
		if (user.getAuthor() == 3) {
			ActionContext.getContext().getSession().put("existAdminUser", user1);
			return "adminIndex";
		} else if (user.getAuthor() == 2) {
			ActionContext.getContext().getSession().put("existWorker", user1);
			return "workerIndex";
		} else  {
			ActionContext.getContext().getSession().put("existCommonUser", user1);
			return "commonIndex";
		}
		
	}
	public String logout(){
		Msg msg=new Msg();
		
			
		switch (user.getAuthor()) {
		case 1:{
			ActionContext.getContext().getSession().put("existCommonUser", null);
		}
			break;
		case 2:{
			ActionContext.getContext().getSession().put("existWorker", null);
		}
			break;
		case 3:{
			ActionContext.getContext().getSession().put("existAdminUser", null);
		}
			break;

		default:
			ActionContext.getContext().getSession().put("existCommonUser", null);
			break;
		}

		return "index";
		
	}

}
