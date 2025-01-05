package com.demo.service;

import java.util.List;

import com.demo.beans.Product;

public interface ProductService {

	boolean addnewProduct();

	List<Product> findAll();

	void closeSessionFactory();

	boolean deleteById(int pid);

	boolean updateById(int pid, int qty, double pr);

	Product findById(int pid);

	List<Product> sortByName();

}
