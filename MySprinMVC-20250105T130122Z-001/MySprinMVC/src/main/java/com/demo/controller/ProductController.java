package com.demo.controller;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.demo.beans.MyUser;
import com.demo.beans.Product;
import com.demo.service.ProductService;

@Controller
@RequestMapping("/product")
public class ProductController {
	@Autowired
	ProductService pservice;
	
	@GetMapping("/getproducts")
	public  ModelAndView getAllProducts() {
		 List<Product> plist=pservice.getAllProducts();
		 
		 return new ModelAndView("showproduct","plist",plist);
	}
	
	@GetMapping("/addnewproduct")
	public String displayForm(Model m) {
		m.addAttribute("u1",new Product());
		return "insertproduct";
	}
	
	@PostMapping("/insertProduct")
	//public ModelAndView inserProduct(@RequestParam int pid,@RequestParam String  pname,@RequestParam int qty,@RequestParam double price,@RequestParam String ldt,@RequestParam int cid) {
	public ModelAndView inserProduct(@ModelAttribute Product p) {	
		//LocalDate ldate=LocalDate.parse(ldt,DateTimeFormatter.ofPattern("dd/MM/yyyy"));
		//Product p=new Product(pid,pname,qty,price,ldate,cid);
		boolean status=pservice.addNewProduct(p);
		return new ModelAndView("redirect:/product/getproducts");
	}
	
	@GetMapping("editproduct/{pid}")
	public ModelAndView editProduct(@PathVariable int pid) {
		Product p=pservice.getById(pid);
		if(p!=null)
		   return new ModelAndView("editproduct","prod",p);
		else {
			return new ModelAndView("redirect:/product/getproducts");
		}
	}
	@PostMapping("/updateProduct")
	
	public ModelAndView updateProduct(@RequestParam int pid,@RequestParam String  pname,@RequestParam int qty,@RequestParam double price,@RequestParam String ldt,@RequestParam int cid) {
		LocalDate ldate=LocalDate.parse(ldt,DateTimeFormatter.ofPattern("dd/MM/yyyy"));
		Product p=new Product(pid,pname,qty,price,ldate,cid);
		boolean status=pservice.updateProduct(p);
		return new ModelAndView("redirect:/product/getproducts");
	}
	
	@GetMapping("deleteproduct/{pid}")
	public ModelAndView deleteProduct(@PathVariable int pid) {
		boolean status=pservice.deleteById(pid);
		return new ModelAndView("redirect:/product/getproducts");
	}

}
