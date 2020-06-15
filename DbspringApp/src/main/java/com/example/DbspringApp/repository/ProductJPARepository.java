package com.example.DbspringApp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.DbspringApp.model.Product;

	@Repository
	public interface ProductJPARepository extends JpaRepository<Product, Integer>{

}
