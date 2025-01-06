package com.demo.SpringbootProductCRUDMVC.service;

import java.util.List;

import com.demo.SpringbootProductCRUDMVC.beans.Product;

public interface ProductService {

	List<Product> getAllProducts();

	Product getProductById(int pid);

	Product addNewProduct(Product p);

	boolean updateProduct(Product p);

	boolean deleteProductById(int pid);

	boolean insertProducts(Product p);

}
