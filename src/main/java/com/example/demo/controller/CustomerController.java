package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Sevice.ICustomerService;
import com.example.demo.entity.Customer;

@RestController
@RequestMapping(value="/customer")
@CrossOrigin(value="http://localhost:3000")
public class CustomerController {
	
	@Autowired
	private ICustomerService customerService;
	
	@GetMapping(value="/allCustomers")
	public ResponseEntity<List<Customer>>getAllCustomers()
	{
		List<Customer> allCustomers=customerService.getAllCustomers();
		return new ResponseEntity<List<Customer>>(allCustomers,HttpStatus.OK);
	}
	
	@GetMapping(value="/{cid}")
	public ResponseEntity <Customer> getCustomer(@PathVariable Integer cid)
	{
		Customer customer=customerService.getCustomer(cid);
		return new ResponseEntity <Customer> (customer, HttpStatus.OK);
	}

}
