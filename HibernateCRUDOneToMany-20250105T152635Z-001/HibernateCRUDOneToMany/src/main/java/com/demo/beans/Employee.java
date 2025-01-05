package com.demo.beans;

import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Employee {
	@Id
	private int eid;
	private String ename;
	private double sal;
	private LocalDate doj;
	@ManyToOne(fetch=FetchType.LAZY,cascade = CascadeType.REFRESH)
	@JoinColumn(name="deptid")
	Department d;
	public Employee() {
		super();
	}
	public Employee(int eid, String ename, double sal, LocalDate doj, Department d) {
		super();
		this.eid = eid;
		this.ename = ename;
		this.sal = sal;
		this.doj = doj;
		this.d = d;
	}
	public int getEid() {
		return eid;
	}
	public void setEid(int eid) {
		this.eid = eid;
	}
	public String getEname() {
		return ename;
	}
	public void setEname(String ename) {
		this.ename = ename;
	}
	public double getSal() {
		return sal;
	}
	public void setSal(double sal) {
		this.sal = sal;
	}
	public LocalDate getDoj() {
		return doj;
	}
	public void setDoj(LocalDate doj) {
		this.doj = doj;
	}
	public Department getD() {
		return d;
	}
	public void setD(Department d) {
		this.d = d;
	}
	@Override
	public String toString() {
		return "Employee [eid=" + eid + ", ename=" + ename + ", sal=" + sal + ", doj=" + doj +"]";
	}
	
	
	

}
