package com.demo.service;

import java.util.List;

import com.demo.beans.Category;

public interface CategoryService {

	List<Category> getAllCategory();

	Category getByCid(int cid);

	boolean addNewCategory(Category c);

	boolean updateCategory(Category c);

	boolean deleteCategory(int cid);

}
