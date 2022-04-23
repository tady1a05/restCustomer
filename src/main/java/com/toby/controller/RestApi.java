package com.toby.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.toby.service.CustomerServiceIntf;
import com.toby.Exception.StudentNotFoundException;
import com.toby.model.*;

@RestController
@RequestMapping("/api")
public class RestApi {
	@Autowired
	public CustomerServiceIntf customerServiceIntf;
	
	@GetMapping("/customers")
	public List<Customer> getAllCustomers(){
		return customerServiceIntf.getAllCustomers();
	}
	
	@GetMapping("/customers/{customerId}")
	public Customer getCustomer(@PathVariable int customerId){
		Customer customer = customerServiceIntf.getCustomer(customerId);
		if(customer == null) {
			throw new StudentNotFoundException(customerId + "bNot Found");
		}
		return customer;
	}
	
	@PostMapping("/customers")
	public Customer createCustomer(@RequestBody Customer customer){
		customerServiceIntf.addCustomer(customer);
		if(customer == null) {
			throw new StudentNotFoundException(customer + " Not Found");
		}
		return customer;
	}
	
	@PutMapping("/customers")
	public Customer updateCustomer(@RequestBody Customer customer){
		customerServiceIntf.addCustomer(customer);
		if(customer == null) {
			throw new StudentNotFoundException(customer + " Not Found");
		}
		return customer;
	}
	
	@DeleteMapping("/customers/{customerId}")
	public String deleteCustomer(@PathVariable int customerId){
		Customer customer = customerServiceIntf.getCustomer(customerId);
		if(customer == null) {
			throw new StudentNotFoundException(customerId + " Not Found");
		}
		customerServiceIntf.deleteCustomer(customer);
		return "delete customer";
	}
}
