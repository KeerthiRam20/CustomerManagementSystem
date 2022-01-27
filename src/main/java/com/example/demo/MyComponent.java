package com.example.demo;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;

import org.springframework.stereotype.Component;

import com.example.demo.entity.Customer;
import com.example.demo.repository.CustomerRepository;

@Component
public class MyComponent implements CommandLineRunner{
	
	@Autowired
	private CustomerRepository customerRepository;

	@Override
	public void run(String... args) throws Exception {
		Customer customer1=new Customer(1,"Keerthi", "Goa","Keerthi@gmail.com");
		Customer customer2=new Customer(2,"Pooja", "Mysore","pooja@gmail.com");
		Customer customer3=new Customer(3,"Ramya", "Goa","ramya@gmail.com");
		Customer customer4=new Customer(4,"nandi,", "Goa","nandi@gmail.com");
		Customer customer5=new Customer(5,"vishuu", "banglore","vishnu@gmail.com");
		
		
		List<Customer> allCustomers=Stream.of(customer1,customer2,customer3,customer4,customer5)
				.collect(Collectors.toList());
		 customerRepository.saveAll(allCustomers);
	}

}
