package com.audioshop.action;

import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.lang3.StringUtils;

import com.audioshop.model.User;
import com.audioshop.service.UserService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class LoginAction extends ActionSupport {
	private String phone;
	private String password;
	@Resource
	private UserService userService;
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	@Override
	public String execute() throws Exception {
		try {
			if(StringUtils.isEmpty(password)||StringUtils.isEmpty(phone)){
				return "login";
			}else{
				List<User> users=userService.login(phone, password);
				if(users!=null&&users.size()>0){
					User user=users.get(0);
					ActionContext actionContext=ActionContext.getContext();
					actionContext.put("userName", user.getName());
					actionContext.put("userPhone", user.getPhone());
					return "success";
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			return "login";
		}
		return "login";
	}
}
