package com.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HelloController {

	public HelloController() {
	System.out.println("Hello Controller created....");
	}
	
	@RequestMapping("/hello")
	public String hello(){
     System.out.println("In HelloCntroller  ello method");
	return "hello";
	}
	
	
	
	
}
