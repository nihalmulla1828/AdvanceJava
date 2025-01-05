package com.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.beans.Category;
import com.demo.dao.CategoryDao;

@Service
public class CategoryServiceImpl implements CategoryService{
 
	@Autowired
	CategoryDao cdao;

	@Override
	public List<Category> getAllCategory() {
		// TODO Auto-generated method stub
		return cdao.findAllCategory();
	}

	@Override
	public Category getByCid(int cid) {
		
		return cdao.findByCid(cid);
	}

	@Override
	public boolean addNewCategory(Category c) {
		
		return cdao.addNewCategory(c);
	}

	@Override
	public boolean updateCategory(Category c) {
		
		return cdao.modifyCategory(c);
	}

	@Override
	public boolean deleteCategory(int cid) {
		
		return cdao.removeByCid(cid);
	}
}
