package com.example.DbspringApp.dao;

import java.util.List;

import com.example.DbspringApp.model.Product;



public interface ProductDao {

	

	Product findProduct(int pid);

	boolean deleteProduct(int pid);

	boolean updateProduct(Product product);

	boolean addProduct(Product product);

	 List<Product> findAllProducts();
}

