package com.example.demo.Sevice;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Customer;
import com.example.demo.exception.CustomerNotFoundException;
import com.example.demo.repository.CustomerRepository;

@Service
public class ICustomerServiceImpl implements ICustomerService{
	
	@Autowired
	private CustomerRepository customerRepository;

	@Override
	public List<Customer> getAllCustomers() {
		
		return customerRepository.findAll();
	}

	@Override
	public Customer getCustomer(Integer cid) {
		// TODO Auto-generated method stub
		return customerRepository.findById(cid).orElseThrow(()-> new CustomerNotFoundException("customer not found"));
	}

}
