package com.demo.service;

import java.util.List;

import com.demo.beans.Employee;

public interface EmployeeService {

	void closeSessionFactory();

	void addnewEmployee();

	boolean deleteById(int eid);

	boolean modifyById(int eid, String name, double sal, int deptid);

	Employee findById(int eid);

	List<Employee> findAll();

	List<Employee> sortBySal();

}
