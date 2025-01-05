package com.demo.controller;

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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demo.beans.Category;
import com.demo.service.CategoryService;

@RestController
@RequestMapping("/category")
public class CategoryController {
	@Autowired
	CategoryService cservice;
	@GetMapping("/categories")
	public ResponseEntity<List<Category>> getAllCategories(){
		
		List<Category> clist = cservice.getAllCategory();
		return ResponseEntity.ok(clist);
	}

	@GetMapping("/categories/{cid}")
	public ResponseEntity<Category> getByCid(@PathVariable int cid){
		
		Category c = cservice.getByCid(cid);
		return ResponseEntity.ok(c);
	} 
	
	@PostMapping("/categories/{cid}")
	public ResponseEntity<String> addCategory(@RequestBody Category c){
		
		boolean status = cservice.addNewCategory(c);
		if(status)
		{
			return ResponseEntity.ok("Data Added Successfully.");
		} 
		
		return new ResponseEntity(HttpStatus.BAD_REQUEST);
	} 
	
	@PutMapping("/categories/{cid}")
	public ResponseEntity<String> updateCategory(@RequestBody Category c){
		
		boolean status = cservice.updateCategory(c);
		if(status)
		{
			return ResponseEntity.ok("Category updated Successfully.");
		} 
		
		return new ResponseEntity(HttpStatus.NOT_FOUND);
	} 
	
	@DeleteMapping("/categories/{cid}")
	public ResponseEntity<String> deleteCategory(@PathVariable int cid){
		
		boolean status = cservice.deleteCategory(cid);
		if(status)
		{
			return ResponseEntity.ok("Category deleted Successfully.");
		} 
		
		return new ResponseEntity(HttpStatus.NOT_FOUND);
	}
}
