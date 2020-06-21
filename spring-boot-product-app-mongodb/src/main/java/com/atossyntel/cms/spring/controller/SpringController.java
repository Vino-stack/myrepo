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
import com.atossyntel.cms.model.Product;
import com.atossyntel.cms.service.ProductService;


@Controller
public class SpringController {
	@Qualifier("esi2")
	@Autowired
	private ProductService productService;

	public SpringController() {
		System.out.println("SpringController created...");
	}
	
	@RequestMapping(value="/sproducts",method=RequestMethod.GET)
	public ModelAndView getAllProducts(){
	return new ModelAndView("ProductList", "products", productService.findAllProducts());	
	}
	
	@RequestMapping(value="/newProduct",method=RequestMethod.GET)
	public String newProduct(ModelMap map){
	
		map.addAttribute("product",new Product());
		map.addAttribute("products",productService.findAllProducts());
		return  "addProduct";
	}   
	
	@RequestMapping(value="/editp/{id}",method=RequestMethod.GET)
	public String newProduct(@PathVariable("id") int pid,ModelMap map){
		System.out.println("In editproduct "+pid);
		map.addAttribute("product",productService.findProductById(pid));
		map.addAttribute("products",productService.findAllProducts());
		return  "editProduct";			
	}
	
	@RequestMapping(value="/deletep",method=RequestMethod.GET)
	public String deleteProduct(@RequestParam("id") int pid,ModelMap map){
	
		System.out.println("In deleteproduct "+pid);
		productService.deleteProduct(pid);
		map.addAttribute("products",productService.findAllProducts());
		return  "ProductList";
			
	}
	@RequestMapping(value="/addp",method=RequestMethod.POST)
	public String addProduct(@ModelAttribute("product") Product product,ModelMap map){
		productService.addProduct(product);
		map.addAttribute("products",productService.findAllProducts());
		return  "ProductList";
			
	}
	
	@RequestMapping(value="/updatep",method=RequestMethod.POST)
	public String updateProduct(@ModelAttribute("product") Product product,ModelMap map){
		productService.addProduct(product);
		map.addAttribute("products", productService.findAllProducts());
		return "ProductList";
	}
	

}
