package com.demo.test;

import java.util.List;
import java.util.Scanner;

import com.demo.beans.Product;
import com.demo.service.ProductService;
import com.demo.service.ProductServiceImpl;

public class TestCRudDemo {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		ProductService pservice=new ProductServiceImpl();
		int choice=0;
		do {
			System.out.println("1. Add new Product\n2. displayall products\n3. delete by id\n4. update by id\n");
			System.out.println("5. display by id\n 6. sort by name\n7.exit\n choice: ");
			choice=sc.nextInt();
			switch(choice) {
			case 1:
				boolean status=pservice.addnewProduct();
				if(status) {
					System.out.println("product added successfully");
					
				}else {
					System.out.println("error occured");
				}
				break;
			case 2:
				List<Product> plist=pservice.findAll();
				plist.forEach(System.out::println);
				break;
			case 3:
				System.out.println("enetr id");
				int pid=sc.nextInt();
				status=pservice.deleteById(pid);
				if(status) {
					System.out.println("product deleted successfully");
					
				}else {
					System.out.println("error occured");
				}
				
				break;
			case 4:
				System.out.println("enter id");
				 pid=sc.nextInt();
				 System.out.println("enter new qty");
				 int qty=sc.nextInt();
				 System.out.println("enter price");
				 double pr=sc.nextDouble();
				status=pservice.updateById(pid,qty,pr);
				if(status) {
					System.out.println("product updated successfully");
					
				}else {
					System.out.println("error occured");
				}
				break;
			case 5:
				System.out.println("enter id");
				 pid=sc.nextInt();
				 Product p=pservice.findById(pid);
				 if(p!=null) {
					 System.out.println(p);
				 }else {
					 System.out.println("product not found "+pid);
				 }
				break;
			case 6:
			    plist=pservice.sortByName();
			    if(plist!=null)
			    	plist.forEach(System.out::println);
			    else
			    	System.out.println("table is empty");
				break;
			case 7:
				System.out.println("Thank you for Visiting......");
				sc.close();
				pservice.closeSessionFactory();
				break;
			default:
				System.out.println("wrong choice");
				break;
				
			}
		}while(choice!=7);
	}

}
