package com.demo.beans;


import java.time.LocalDate;

import org.springframework.format.annotation.DateTimeFormat;

public class Product {
	private int pid;
	private String pname;
	private int qty;
	private double price;
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	private LocalDate ldt;
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
		this.ldt = ldt;
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

	public LocalDate getLdt() {
		return ldt;
	}

	public void setLdt(LocalDate date) {
		this.ldt = date;
	}

	public int getCid() {
		return cid;
	}

	public void setCid(int cid) {
		this.cid = cid;
	}

	@Override
	public String toString() {
		return "Product [pid=" + pid + ", pname=" + pname + ", qty=" + qty + ", price=" + price + ", ldt=" + ldt
				+ ", cid=" + cid + "]";
	}
	

}
