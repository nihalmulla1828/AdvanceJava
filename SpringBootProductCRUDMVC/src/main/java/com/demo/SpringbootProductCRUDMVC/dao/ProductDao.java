package com.demo.SpringbootProductCRUDMVC.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.demo.SpringbootProductCRUDMVC.beans.Product;

public interface ProductDao extends JpaRepository<Product, Integer> {

}
