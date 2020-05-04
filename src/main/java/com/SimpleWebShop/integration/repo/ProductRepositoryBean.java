package com.SimpleWebShop.integration.repo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.SimpleWebShop.integration.api.EntityManager;
import com.SimpleWebShop.integration.entities.CartEntity;
import com.SimpleWebShop.integration.entities.Entity;

@Transactional
@Repository
public class ProductRepositoryBean implements ProductRepository {

	@Autowired
	private EntityManager entityManagerBean;

	@Override
	@Cacheable("products")
	public List<Entity> retriveProducts(String category) {
		return entityManagerBean.readTable(category);
	}

	@Override
	public void initializeDataBase() {
		entityManagerBean.initializeDataBase();

	}

	@Override
	public void updateCartDataBase(CartEntity cartEntity) {
		entityManagerBean.updateCartDataBase(cartEntity);

	}

	@Override
	public List<Entity> retriveCartProducts(String category) {
		return entityManagerBean.readCartTable(category);
	}

	@Override
	public void emptyCart() {
		entityManagerBean.emptyCartDataBase();

	}

}
