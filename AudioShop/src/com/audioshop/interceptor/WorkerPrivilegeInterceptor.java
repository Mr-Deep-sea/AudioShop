package com.audioshop.interceptor;

import org.apache.struts2.ServletActionContext;

import com.audioshop.model.User;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.interceptor.MethodFilterInterceptor;

public class WorkerPrivilegeInterceptor extends MethodFilterInterceptor {
	@Override
	protected String doIntercept(ActionInvocation actionInvocation)  {
		try {
			User workerUser = (User)actionInvocation.getInvocationContext()
					.getSession().get("existWorker");
			if(workerUser != null){
				return actionInvocation.invoke();
			}else{
				ActionSupport support = (ActionSupport) actionInvocation.getAction();
				support.addActionError("您还没有登录!没有权限访问!");
				//return ActionSupport.LOGIN;
				return "workerLogin";
			}
		} catch (Exception e) {
			// TODO: handle exception
			return "workerLogin";
		}
		
	}
	@Override
	public String intercept(ActionInvocation invocation) throws Exception {
		// TODO Auto-generated method stub
		return super.intercept(invocation);
	}
}
