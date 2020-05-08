package com.SimpleWebShop.integration.repo;

import java.util.List;

import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import com.SimpleWebShop.integration.entities.Customer;

@Repository
public class CustomerDAOSimpleJPA {

	// need to inject the session factory
	@PersistenceContext
	private javax.persistence.EntityManager entityManager;

	// @Transactional
	public List<Customer> getCustomers() {

		// get the current hibernate session
		// Session currentSession = sessionFactory.getClass()getCurrentSession();
		// Transaction tx = currentSession.beginTransaction();
		// create a query
		javax.persistence.TypedQuery<Customer> theQuery = entityManager.createQuery("from Customer",
				Customer.class);

		// execute query and get result list
		List<Customer> customers = theQuery.getResultList();
		// tx.commit();
		// return the results
		return customers;
	}

}
