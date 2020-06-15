package com.example.DbspringApp.controller;

import java.util.Date;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HelloController {
	
public HelloController() {
System.out.println("Hello controller created...");
}	
@RequestMapping("/welcome")
public ModelAndView welcome(){
	return new ModelAndView("welcome","message","Welcome To Spring Web MVC");
}
@RequestMapping("/today")
public   @ResponseBody String today(){
	return "Today is :"+new Date();
}
@RequestMapping("/home")
public String hello1(){
	return "home";
}



	
	
	
}


