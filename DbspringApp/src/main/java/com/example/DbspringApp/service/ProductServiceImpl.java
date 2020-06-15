package com.example.DbspringApp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.DbspringApp.model.Product;
import com.example.DbspringApp.repository.ProductJPARepository;

@Service("esi2")
public class ProductServiceImpl implements ProductService{
	
	@Autowired
	private ProductJPARepository repository;

	public ProductServiceImpl() {
		System.out.println("Productseviceimpl defualt constructor created");
	}
	 
	public 	Product findProduct(int pid) {
		return repository.findById(pid).get();
		
	}
	
	@Override
	public boolean deleteProduct(int pid) {

		Product p = repository.findById(pid).get();

		if (p != null) {
			repository.delete(p);
			return true;
		}

		return false;
	}
	
	@Override
	public boolean updateProduct(Product product) {

		Product p = repository.findById(product.getPid()).get();

		if (p != null) {
			repository.save(product);
			return true;
		}

		return false;
	}
	
	@Override
	public boolean addProduct(Product product) {
		// TODO Auto-generated method stub
		return repository.save(product) == product;
	}

	@Override
	public List<Product> findAllProducts() {

		return repository.findAll();
	}

}
