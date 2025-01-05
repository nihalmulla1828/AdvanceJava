package com.demo.service;

import java.util.List;

import com.demo.beans.Category;
import com.demo.beans.Product;

public interface ProductService {

	List<Category> getAllCategory();

	List<Product> getProductsBycid(int cid);

	Product getById(int parseInt);

}
