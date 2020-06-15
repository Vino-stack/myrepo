package com.example.DbspringApp.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.example.DbspringApp.data.ProductMap;
import com.example.DbspringApp.model.Product;

@Repository
@Component("productMapDaoImpl")

public class ProductMapDaoImpl implements ProductDao {

	public ProductMapDaoImpl() {
		System.out.println("Productdaoimpl defualt constructor created");

	}
	
	@Override
	public boolean addProduct(Product product) {
		return ProductMap.INSTANCE.getMap().put(product.getPid(), product) == product;
	}
	
	@Override
	public Product findProduct(int pid) {
		return ProductMap.INSTANCE.getMap().get(pid);
	}
	
	@Override
	public boolean deleteProduct(int pid) {

		if (ProductMap.INSTANCE.getMap().containsKey(pid)) {
			ProductMap.INSTANCE.getMap().remove(pid);
			return true;
		}
		return false;
		
	}

	@Override
	public 	boolean updateProduct(Product product) {
		if (ProductMap.INSTANCE.getMap().containsKey(product.getPid())) {
			ProductMap.INSTANCE.getMap().put(product.getPid(), product);
			return true;
		}
		return false;
		
	}
	
	@Override
	 public List<Product> findAllProducts(){
		 return new ArrayList<>(ProductMap.INSTANCE.getMap().values());
	 }
	

}
