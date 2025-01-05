package com.demo.service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Scanner;

import com.demo.beans.Department;
import com.demo.beans.Employee;
import com.demo.dao.EmployeeDao;
import com.demo.dao.EmployeeDaoImpl;

public class EmployeeServiceImpl implements EmployeeService{
   EmployeeDao edao;

public EmployeeServiceImpl() {
	super();
	this.edao = new EmployeeDaoImpl();
	
}

public void closeSessionFactory() {
	edao.closeMyConnection();
	
}

public void addnewEmployee() {
	Scanner sc=new Scanner(System.in);
	System.out.println("enetr id");
	int eid=sc.nextInt();
	System.out.println("enetr name");
	String ename=sc.next();
	System.out.println("enetr sal");
	double sal=sc.nextDouble();
	System.out.println("enetr doj(dd/MM/yyyy)");
	String dt=sc.next();
	LocalDate ldt=LocalDate.parse(dt,DateTimeFormatter.ofPattern("dd/MM/yyyy"));
	System.out.println("enter deptid");
	int deptid=sc.nextInt();
	
	Employee e=new Employee(eid,ename,sal,ldt,new Department(deptid));
	edao.saveEmployee(e);
	
	
}

public boolean deleteById(int eid) {
	return edao.removeById(eid);
}

public boolean modifyById(int eid, String name, double sal, int deptid) {
	return edao.updateById(eid,name,sal,deptid);
}

public Employee findById(int eid) {
	return edao.getById(eid);
}

@Override
public List<Employee> findAll() {
	return edao.getAll();
}

@Override
public List<Employee> sortBySal() {
	return edao.arrangeBySal();
}
   
}
