package edu.ustb.service.impl;

import java.util.ArrayList;
import java.util.List;

import edu.ustb.dao.CategoryDao;
import edu.ustb.dao.impl.CategoryDaoImpl;
import edu.ustb.domain.Category;
import edu.ustb.service.CategoryService;

public class CategoryServiceImpl implements CategoryService{
	private CategoryDao categoryDao=new CategoryDaoImpl();
	
	public List<Category> getAllCategory(){
		List<Category> list = new ArrayList();
		list=categoryDao.getAllCategory();
		return list;
	}
}
