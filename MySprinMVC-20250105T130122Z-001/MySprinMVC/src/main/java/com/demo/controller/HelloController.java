package com.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller

public class HelloController {
	
	//@RequestMapping("/hello")
		@GetMapping("/")
		public String welcomefile() {
			return "index";
		}
		
	//@RequestMapping("/hello")
	@GetMapping("/hello")
	public String sayHello() {
		return "hello";
	}
	@GetMapping("/message")
	public ModelAndView getMessage() {
		String message="this is message from getMessage";
		return new ModelAndView("showmessage","msg",message);
	}
	

}
