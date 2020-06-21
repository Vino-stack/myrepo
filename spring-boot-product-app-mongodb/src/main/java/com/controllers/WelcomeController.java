package com.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class WelcomeController {

	public WelcomeController() {
	System.out.println("WelcomeController created....");
	}
	
	@RequestMapping(value="/welcome",method=RequestMethod.GET)
	public ModelAndView welcome(){
     System.out.println("In WelcomeController  welcome method");
	return new ModelAndView("welcome", "message", "Welcome To Spring Web MVC at Atos Syntel");
	}	
	
}
