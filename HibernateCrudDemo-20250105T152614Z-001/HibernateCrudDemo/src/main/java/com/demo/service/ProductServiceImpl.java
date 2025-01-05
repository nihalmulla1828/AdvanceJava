package com.demo.service;

import java.util.List;
import java.util.Scanner;

import com.demo.beans.Product;
import com.demo.dao.ProductDao;
import com.demo.dao.ProductDaoImpl;

public class ProductServiceImpl implements ProductService{
    private ProductDao pdao;

	public ProductServiceImpl() {
		super();
		this.pdao = new ProductDaoImpl();
	}

	public boolean addnewProduct() {
		Scanner sc=new Scanner(System.in);
		//System.out.println("Enetr pid");
		//int pid=sc.nextInt();
		System.out.println("Enetr pname");
		String pname=sc.next();
		System.out.println("Enetr Qty");
		int qty=sc.nextInt();
		System.out.println("Enetr price");
		double price=sc.nextDouble();
		Product p=new Product(pname,qty,price);
		return pdao.saveProduct(p);
	}

	@Override
	public List<Product> findAll() {
		return pdao.getAll();
	}

	@Override
	public void closeSessionFactory() {
		pdao.shutdownSessionFactory();
		
	}

	@Override
	public boolean deleteById(int pid) {
		return pdao.removeById(pid);
	}

	@Override
	public boolean updateById(int pid,int qty,double price) {
		return pdao.modifyById(pid,qty,price);
	}

	@Override
	public Product findById(int pid) {
		return pdao.getById(pid);
	}

	@Override
	public List<Product> sortByName() {
		return pdao.arrangeByName();
	}
    
}
