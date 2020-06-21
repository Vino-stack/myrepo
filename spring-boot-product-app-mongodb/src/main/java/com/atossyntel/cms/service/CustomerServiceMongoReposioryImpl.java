package com.atossyntel.cms.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.atossyntel.cms.model.Customer;
import com.atossyntel.cms.repository.CustomerReository;

@Service
public class CustomerServiceMongoReposioryImpl implements CustomerService {

	// //The dao repository will use the Mongodb-Repository to perform the database operations.
	// dependency
	@Autowired
	private CustomerReository repository;

	public CustomerServiceMongoReposioryImpl() {
		System.out.println("###### CustomerServiceReposioryImpl created... #########");
	}

	@Override
	public boolean addCustomer(Customer customer) {
			
		// TODO Auto-generated method stub
		return repository.save(customer) == customer;
	}

	@Override
	public boolean updateCustomer(Customer customer) {

		Customer c = repository.findById(customer.getCustomerId()).get();

		if (c != null) {
			return repository.save(customer) == customer;
		}

		return false;
	}

	@Override
	public boolean deleteCustomer(int customerId) {

		Customer customer = repository.findById(customerId).get();

		if (customer != null) {
			repository.delete(customer);
			return true;
		}
		
		return false;
		
	}

	@Override
	public Customer findCustomerById(int customerId) {
		// TODO Auto-generated method stub
		return repository.findById(customerId).get();
	}

	@Override
	public List<Customer> findAllCustomers() {
		// TODO Auto-generated method stub
		return repository.findAll();
	}

}
