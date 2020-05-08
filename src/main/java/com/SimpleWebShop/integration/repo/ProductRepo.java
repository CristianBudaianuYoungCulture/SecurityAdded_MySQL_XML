package com.SimpleWebShop.integration.repo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.SimpleWebShop.integration.entities.ProductEntity;

@Repository
public class ProductRepo<T> {

	@Autowired
	ProductDAO productDAO;

	public List<ProductEntity> findByCategory(String category) {
		return productDAO.findByCategory(category);
	}

}
