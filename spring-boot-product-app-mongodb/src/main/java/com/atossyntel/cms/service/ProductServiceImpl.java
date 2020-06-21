package com.atossyntel.cms.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.atossyntel.cms.model.Product;
import com.atossyntel.cms.repository.ProductMongoRepository;


@Service("esi2")
public class ProductServiceImpl implements ProductService{
	
	@Autowired
	private ProductMongoRepository repository;

	public ProductServiceImpl() {
		System.out.println("Productseviceimpl defualt constructor created");
	}
	 
	public 	Product findProductById(int pid) {
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
