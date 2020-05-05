package com.SimpleWebShop.integration.repo;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.SimpleWebShop.integration.entities.Person;

public interface PersonRepository<P> extends CrudRepository<Person, Long> {
	List<Person> findByFirstName(String firstName);
}
