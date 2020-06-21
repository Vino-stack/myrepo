package com.atossyntel.cms.rest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.atossyntel.cms.model.Product;
import com.atossyntel.cms.service.ProductService;


@RequestMapping("/products") // is common to all the mapping methods
@RestController //(@Controller+@ResponseBody)
public class RestController1 {
	@Qualifier("esi2")
	@Autowired
	private ProductService productService;

	public RestController1() {
		System.out.println("RestController created...");
	}
	
	@GetMapping
	public List<Product> getAllProducts() {
		System.out.println("In get allproducts");
		return productService.findAllProducts();
	}
	
	@GetMapping("/{pid}")
	public Product getProduct(@PathVariable("pid") int pid) {
		System.out.println("In get product " + pid);
		return productService.findProductById(pid);
	}

	@DeleteMapping("/{pid}")
	public List<Product> deleteProduct(@PathVariable("pid") int pid) {
		System.out.println("In delete Product " + pid);
		productService.deleteProduct(pid);
		return productService.findAllProducts();
	}
	
	@PutMapping("/{pid}")
	public List<Product> updateProduct(@PathVariable("pid") int pid,@RequestBody Product product) {
		System.out.println("In update Product " + pid);
		productService.updateProduct(product);
		return productService.findAllProducts();
	}
	
	@PostMapping
	public List<Product> addProduct(@RequestBody Product product) {
		System.out.println("In add product " + product);
		productService.addProduct(product);
		return productService.findAllProducts();
	}	
	
	/*{
    "pname" : "Smart phone S10",
    "qty" : 5,
    "pbrand" : "Lenovo",
    "pprice" : 8000
}*/
	
	
	
	
	
}
