package com.SimpleWebShop.integration.repo;

import java.util.List;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.SimpleWebShop.integration.entities.CartEntity;

public interface CartDAO extends CrudRepository<CartEntity, Long> {

	@Query("SELECT u FROM CartEntity u WHERE u.user = :user")
	List<CartEntity> findByUser(@Param("user") String user);

	@Transactional
	@Modifying
	@Query("DELETE FROM CartEntity u WHERE u.user = :user")
	int deleteByUser(@Param("user") String user);
}
