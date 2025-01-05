package com.demo.SpringBootRestWebservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.demo.SpringBootRestWebservice.beans.Product;
import com.demo.SpringBootRestWebservice.dto.ProductDto;
import com.demo.SpringBootRestWebservice.service.ProductService;

@RestController
public class ProductController {
	
	@Autowired
	ProductService pservice;
	
	@GetMapping("/products")
	public ResponseEntity<List<ProductDto>> getAllProducts(){
		List<ProductDto> plist=pservice.getAllProducts();
		return ResponseEntity.ok(plist);
	}
	
	@GetMapping("/products/{pid}")
	public ResponseEntity<ProductDto> getById(@PathVariable int pid){
		ProductDto p=pservice.getById(pid);
		if(p!=null)
			return ResponseEntity.ok(p);
		else
			return ResponseEntity.status(500).body(null);
	}
	@GetMapping("/category/products/{cid}")
	public ResponseEntity<List<ProductDto>> getByCategory(@PathVariable int cid){
		List<ProductDto> plist=pservice.findByCategory(cid);
		
		return ResponseEntity.ok(plist);
		
	}
	
	@PostMapping("/products/{pid}")
	public ResponseEntity<String> addProduct(@RequestBody ProductDto p){
		boolean status=pservice.addNewProduct(p);
		if(status) {
			return ResponseEntity.ok("Data added successfully");
		}
		else {
			return new ResponseEntity(HttpStatus.NOT_FOUND);
		}
	}
	
	
	@PutMapping("/products/{pid}")
	public ResponseEntity<String> updateProduct(@RequestBody ProductDto p){
		boolean status=pservice.updateProduct(p);
		if(status) {
			return ResponseEntity.ok("Data updated successfully");
		}
		else {
			return new ResponseEntity(HttpStatus.NOT_FOUND);
		}
	}
	
	@DeleteMapping("/products/{pid}")
	public ResponseEntity<String> deleteProduct(@PathVariable int pid){
		boolean status=pservice.deleteById(pid);
		if(status) {
			return ResponseEntity.ok("Data deleted successfully");
		}
		else {
			return new ResponseEntity(HttpStatus.NOT_FOUND);
		}
	}
	//@GetMapping("/products/{lpr}/{hpr})
	

}
