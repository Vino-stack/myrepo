package com.atossyntel.cms.rest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.atossyntel.cms.model.Customer;
import com.atossyntel.cms.service.CustomerService;

@RequestMapping("/customers")
@RestController 
public class CustomerRestController {
	
//dependency	

@Autowired
private CustomerService customerService; 	

public CustomerRestController() {
System.out.println("########CustomerRestController created....######");
}

//in mongodb db.demo.find()
//get all customers
@GetMapping
public List<Customer> getAllCustomers(){
	return customerService.findAllCustomers();

}

//get customer by customer id
@GetMapping("/{id}")
public Customer getCustomerByI(@PathVariable("id") int customerId){
	return customerService.findCustomerById(customerId);
}

//http://localhost:8000//spring-customer-web-mvc/customers/2
//delete customer by customer id
@DeleteMapping("/{id}")
public List<Customer> deleteCustomerById(@PathVariable("id") int customerId){
	customerService.deleteCustomer(customerId);
	return customerService.findAllCustomers();

}

//update customer by customer id
@PutMapping("/{id}")
public List<Customer> updateCustomerById(@PathVariable("id") int customerId,@RequestBody Customer customer){
	
	customerService.updateCustomer(customer);
	
	return customerService.findAllCustomers();
}

/*using Postman:http://localhost:8000//spring-customer-web-mvc/customers
 * {
"firstName":"Riya",
"lastName":"N",
"gender":"f",
"email":"riya@syntelinc.com",
"address":"kh",
"city":"bangalore",
"state":"KA"
}
 * 
 */
//add customer 
@PostMapping
public List<Customer> addCustomer(@RequestBody Customer customer){	
	customerService.addCustomer(customer);	
	return customerService.findAllCustomers();
}
}
