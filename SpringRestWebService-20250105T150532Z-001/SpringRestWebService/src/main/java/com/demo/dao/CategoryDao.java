package com.demo.dao;

import java.util.List;

import com.demo.beans.Category;

public interface CategoryDao {

	List<Category> findAllCategory();

	Category findByCid(int cid);

	boolean addNewCategory(Category c);

	boolean modifyCategory(Category c);

	boolean removeByCid(int cid);

}
