package com.demo.dao;

import java.util.List;
import java.util.Scanner;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.demo.beans.Product;

public class ProductDaoImpl implements ProductDao {
     static SessionFactory sf;
     static {
    	 sf=HibernateUtil.getMyConnection();
     }
     
     //add a object in the table
	public boolean saveProduct(Product p) {
		Session sess=sf.openSession();
		Transaction tr=sess.beginTransaction();
		sess.save(p);
		tr.commit();
		sess.close();
		return true;
		
		
	}

	@Override
	public List<Product> getAll() {
		Session sess=sf.openSession();
		Transaction tr=sess.beginTransaction();
		Query query=sess.createQuery("from Product");
		List<Product> plist=query.getResultList();
		tr.commit();
		sess.close();
		return plist;
	}

	@Override
	public void shutdownSessionFactory() {
		HibernateUtil.closeMyConnection();
		
	}

	@Override
	public boolean removeById(int pid) {
		Session sess=sf.openSession();
		Transaction tr=sess.beginTransaction();
		Product p=sess.get(Product.class, pid);
		boolean status;
		if(p!=null) {
			sess.delete(p);
			status=true;
			
		}else {
			status= false;
		}
		tr.commit();
		sess.close();
		return status;
	}

	@Override
	public boolean modifyById(int pid,int qty,double price) {
		Session sess=sf.openSession();
		Transaction tr=sess.beginTransaction();
		Product p=sess.get(Product.class, pid);
		if(p!=null) {
			p.setQty(qty);
			p.setPrice(price);
			sess.update(p);
			tr.commit();
			sess.close();
			return true;
		}
		sess.close();
		return false;
		
	}

	@Override
	public Product getById(int pid) {
		Session sess=sf.openSession();
		Transaction tr=sess.beginTransaction();
		Product p=sess.get(Product.class, pid);
		if(p!=null) {
			tr.commit();
			sess.close();
			return p;
		}
		sess.close();
		return null;
	}

	@Override
	public List<Product> arrangeByName() {
		Session sess=sf.openSession();
		Transaction tr=sess.beginTransaction();
		Query query=sess.createQuery("from Product p order by p.pname desc");
		List<Product> plist=query.getResultList();
		tr.commit();
		sess.close();
		return plist;
	}

}
