package com.demo.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.demo.beans.Department;

public class DeptDaoImpl implements DeptDao{
   static SessionFactory sf;
   static {
	   sf=HibernateUtil.getMyConnection();
   }
@Override
public void saveDepartment(Department d) {
	Session sess=sf.openSession();
	Transaction tr=sess.beginTransaction();
	sess.save(d);
	tr.commit();
	sess.close();
	
}
}
