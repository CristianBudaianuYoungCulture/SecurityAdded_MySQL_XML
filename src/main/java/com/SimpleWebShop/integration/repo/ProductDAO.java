package com.SimpleWebShop.integration.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.SimpleWebShop.integration.entities.ProductEntity;

public interface ProductDAO extends JpaRepository<ProductEntity, Long> {

	@Query("SELECT u FROM ProductEntity u WHERE u.category = :category")
	List<ProductEntity> findByCategory(@Param("category") String category);

}
