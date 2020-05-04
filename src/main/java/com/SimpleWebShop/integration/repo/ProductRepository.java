package com.SimpleWebShop.integration.repo;

import java.util.List;

import com.SimpleWebShop.integration.entities.CartEntity;
import com.SimpleWebShop.integration.entities.Entity;

public interface ProductRepository {

	List<Entity> retriveProducts(String category);

	void updateCartDataBase(CartEntity cartEntity);

	List<Entity> retriveCartProducts(String category);

	void emptyCart();

	void initializeDataBase();

}
