package com.SimpleWebShop.integration.repo.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.SimpleWebShop.integration.repo.entity.Customer;

@Repository
public class CustomerDAOBean implements CustomerDAO {

	// need to inject the session factory
	@Autowired
	private javax.persistence.EntityManagerFactory entityManagerFactory;

	@Override
	@Transactional
	public List<Customer> getCustomers() {

		// get the current hibernate session
		// Session currentSession = sessionFactory.getClass()getCurrentSession();
		// Transaction tx = currentSession.beginTransaction();
		// create a query
		javax.persistence.Query theQuery = entityManagerFactory.createEntityManager().createQuery("from Customer");

		// execute query and get result list
		List<Customer> customers = theQuery.getResultList();
		// tx.commit();
		// return the results
		return customers;
	}

}
