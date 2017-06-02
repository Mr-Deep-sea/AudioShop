package com.audioshop.util;



import org.springframework.context.support.ClassPathXmlApplicationContext;

public class getObjectBySpring {
	private final static ClassPathXmlApplicationContext ctx=new ClassPathXmlApplicationContext("applicationContext.xml");
	public static Object getObject(String objectName) {
		return ctx.getBean(objectName);
	}
}
