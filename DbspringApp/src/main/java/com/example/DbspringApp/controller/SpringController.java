package com.example.DbspringApp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.example.DbspringApp.model.Product;
import com.example.DbspringApp.service.ProductService;

@Controller
public class SpringController {
	@Qualifier("esi2")
	@Autowired
	private ProductService productService;

	public SpringController() {
		System.out.println("SpringController created...");
	}
	
	@RequestMapping("/sproducts")
	public ModelAndView getAllProducts(){
	return new ModelAndView("ProductList", "products", productService.findAllProducts());	
	}
	
	@RequestMapping("/sproducts/edit/{id}")
	public String editEmployee(@PathVariable("id") int pid,ModelMap map){
		System.out.println("In editproduct "+pid);
		
		map.addAttribute("product",productService.findProduct(pid));
		map.addAttribute("products",productService.findAllProducts());
			
	return  "editProduct";			
	}
	
	@RequestMapping("/sproducts/delete")
	public String deleteProduct(@RequestParam("pid") int pid,ModelMap map){
	
		System.out.println("In deleteproduct "+pid);
		
		
		productService.deleteProduct(pid);
	
		map.addAttribute("produts",productService.findAllProducts());
		
		
	     return  "productList";
			
	}

	@RequestMapping("/sproducts/new")
	public String newProduct(ModelMap map){
	
		map.addAttribute("product",new Product());
		map.addAttribute("products",productService.findAllProducts());
	
	   return  "addProduct";
			
	}
	
	@RequestMapping(value="/sproducts/add",method=RequestMethod.POST)
	public String addProduct(Product product,ModelMap map){
	
		productService.addProduct(product);
		
		map.addAttribute("product",productService.findAllProducts());
	
	   return  "productList";
			
	}
	
	
	@RequestMapping(value="/sproducts/update",method=RequestMethod.POST)
	
	public String updateEmployee(Product product,ModelMap map){
	
		productService.updateProduct(product);
		
		map.addAttribute("products",productService.findAllProducts());
	
	   return  "productList";
			
	}
	

}
