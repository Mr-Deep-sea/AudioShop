package com.audioshop.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.audioshop.dao.CategoryDao;
import com.audioshop.model.Category;
import com.audioshop.service.CategoryService;

@Service("categoryService")
public class CategoryServiceImpl extends BaseServiceImpl<Category> implements
		CategoryService {
	private CategoryDao categoryDao;

	@Resource
	public void setCategoryDao(CategoryDao categoryDao) {
		super.setBaseDao(categoryDao);
		this.categoryDao = categoryDao;
	}

}
