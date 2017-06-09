package com.audioshop.test.dao;

import java.util.List;

import com.audioshop.dao.CategoryDao;
import com.audioshop.model.Category;
import com.audioshop.util.getObjectBySpring;

public class CategoryDaoTest {
	public static void main(String[] args) {
		CategoryDao categoryDao=(CategoryDao)getObjectBySpring.getObject("categoryDao");
		List<Category> categories=categoryDao.findObjects();
		for (Category category : categories) {
			System.out.println(category.getName());
		}
	}
}
