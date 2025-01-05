package com.demo.SpringBootRestWebservice.beans;


import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.Id;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
@Entity
public class Product {
	@Id
	private int pid;
	private String pname;
	private int qty;
	private double price;
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private LocalDate expdate;
	private int cid;
	
	public Product() {
		super();
	}

	public Product(int pid, String pname, int qty, double price, LocalDate ldt, int cid) {
		super();
		this.pid = pid;
		this.pname = pname;
		this.qty = qty;
		this.price = price;
		this.expdate = ldt;
		this.cid = cid;
	}

	public int getPid() {
		return pid;
	}

	public void setPid(int pid) {
		this.pid = pid;
	}

	public String getPname() {
		return pname;
	}

	public void setPname(String pname) {
		this.pname = pname;
	}

	public int getQty() {
		return qty;
	}

	public void setQty(int qty) {
		this.qty = qty;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public LocalDate getExpdate() {
		return expdate;
	}

	public void setExpdate(LocalDate date) {
		this.expdate = date;
	}

	public int getCid() {
		return cid;
	}

	public void setCid(int cid) {
		this.cid = cid;
	}

	@Override
	public String toString() {
		return "Product [pid=" + pid + ", pname=" + pname + ", qty=" + qty + ", price=" + price + ", expdate=" + expdate
				+ ", cid=" + cid + "]";
	}
	

}
