package com.example.demo.Sevice;

import java.util.List;

import com.example.demo.entity.Customer;

public interface ICustomerService {

	public List<Customer> getAllCustomers();
	public Customer getCustomer(Integer cid);
}
