package com.toby.dao;
import java.util.List;

import com.toby.model.Customer;

public interface CustomerDaoIntf {
	public List<Customer> getAllCustomers();
	
	public void addCustomer(Customer customer);
	
	public Customer getCustomer(int id);
	
	public void deleteCustomer(Customer customer);
}
