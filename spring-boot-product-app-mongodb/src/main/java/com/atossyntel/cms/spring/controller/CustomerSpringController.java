package com.atossyntel.cms.spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.atossyntel.cms.model.Customer;
import com.atossyntel.cms.service.CustomerService;

@Controller
public class CustomerSpringController {
	
//dependency	
@Autowired
private CustomerService customerService; 	

public CustomerSpringController() {
System.out.println("########CustomerSpringController created....######");
}


@RequestMapping(value="/scustomers",method=RequestMethod.GET)
public ModelAndView getAllCustomers(){
	return new ModelAndView("customerList", "customers", customerService.findAllCustomers());
}


@RequestMapping(value="/newCustomer",method=RequestMethod.GET)
public String newCustomer(ModelMap map){
	
	map.addAttribute("customer", new Customer());
	map.addAttribute("customers", customerService.findAllCustomers());
		
	return "addCustomer";
}


@RequestMapping(value="/edit/{id}",method=RequestMethod.GET)
public String newCustomer(@PathVariable("id") int customerId,ModelMap map){
	
	map.addAttribute("customer", customerService.findCustomerById(customerId));
	map.addAttribute("customers", customerService.findAllCustomers());
		
	return "editCustomer";
}


@RequestMapping(value="/delete",method=RequestMethod.GET)
public String deleteCustomer(@RequestParam("id") int customerId,ModelMap map){
	
	customerService.deleteCustomer(customerId);
	
	map.addAttribute("customers", customerService.findAllCustomers());
		
	return "customerList";
}


@RequestMapping(value="/add",method=RequestMethod.POST)
public String addCustomer(@ModelAttribute("customer") Customer customer,ModelMap map){
	customerService.addCustomer(customer);
	map.addAttribute("customers", customerService.findAllCustomers());
	return "customerList";
}


@RequestMapping(value="/update",method=RequestMethod.POST)
public String upateCustomer(@ModelAttribute("customer") Customer customer,ModelMap map){
	customerService.addCustomer(customer);
	map.addAttribute("customers", customerService.findAllCustomers());
	return "customerList";
}



}
