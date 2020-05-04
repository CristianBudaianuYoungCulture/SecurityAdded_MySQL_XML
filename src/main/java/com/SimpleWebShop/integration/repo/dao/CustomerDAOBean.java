package com.SimpleWebShop.integration.repo.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.SimpleWebShop.integration.repo.entity.Customer;

@Repository
public class CustomerDAOBean implements CustomerDAO {

	// need to inject the session factory
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	@Transactional
	public List<Customer> getCustomers() {

		// get the current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
		Transaction tx = currentSession.beginTransaction();
		// create a query
		Query theQuery = currentSession.createQuery("from Customer");

		// execute query and get result list
		List<Customer> customers = theQuery.list();
		tx.commit();
		// return the results
		return customers;
	}

}
