package com.controllers;

import java.util.Date;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.DispatcherServlet;
import org.springframework.web.servlet.ModelAndView;

@RequestMapping(value="/greet")
@Controller
public class GreetController {
	
	public GreetController() {
	System.out.println("GreetController created....");
	}
	
    @RequestMapping
	public ModelAndView greet(){
     System.out.println("In GreetContrller  greet method");
	return new ModelAndView("greet", "message", "Today is "+new Date());
	}	

    @RequestMapping("/today")
	public  @ResponseBody String today(){
     System.out.println("In GreetContrller  today method");
	 return "Today is "+new Date();
	}	
	
}
