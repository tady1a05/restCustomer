package com.toby.dao;

import java.util.List;

import javax.sql.DataSource;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.toby.model.Customer;

@Repository
public class CustomerDao implements CustomerDaoIntf{
	@Autowired
	public SessionFactory sessionfactory;
	
	@Override
	public List<Customer> getAllCustomers() {
		Session session = sessionfactory.getCurrentSession();
		List<Customer> customers = session.createQuery("select c from Customer c").getResultList();
		System.out.println(customers.size());
		return customers;
	}

	@Override
	public void addCustomer(Customer customer) {
		Session session = sessionfactory.getCurrentSession();
		System.out.println(customer);
		session.saveOrUpdate(customer);
	}

	@Override
	public Customer getCustomer(int id) {
		Session session = sessionfactory.getCurrentSession();
		Customer customer = session.get(Customer.class, id);
		System.out.println(customer);
		return customer;
	}

	@Override
	public void deleteCustomer(Customer customer) {
		Session session = sessionfactory.getCurrentSession();
		session.delete(customer);
	}

}
