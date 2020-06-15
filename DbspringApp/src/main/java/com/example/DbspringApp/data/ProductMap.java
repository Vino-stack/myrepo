package com.example.DbspringApp.data;

import java.util.HashMap;
import java.util.Map;

import com.example.DbspringApp.model.Product;

public enum ProductMap {
	INSTANCE;
	
	private Map<Integer, Product> map;
	
	private ProductMap() {
		map=new HashMap<>();
		
		Product p1=new Product("Laptop64bit",100,"Lenovo",77007);
		Product p2=new Product("Laptop64bit",50,"DELL",7777);
		Product p3=new Product("Smartphone",100,"Realme",6666);
		Product p4=new Product("Smartphone",100,"Samsung",5555);
		Product p5=new Product("Smartphone",100,"Xiami",55556);
		
		map.put(p1.getPid(),p1);
		map.put(p2.getPid(),p2);
		map.put(p3.getPid(),p3);
		map.put(p4.getPid(),p4);
		map.put(p5.getPid(),p5);
		
	}
	public Map<Integer, Product> getMap() {
		return map;
	}
		
}
