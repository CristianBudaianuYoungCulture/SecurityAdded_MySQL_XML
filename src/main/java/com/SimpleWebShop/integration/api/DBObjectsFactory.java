package com.SimpleWebShop.integration.api;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.SimpleWebShop.integration.entities.CarEntity;
import com.SimpleWebShop.integration.entities.DiamondEntity;
import com.SimpleWebShop.integration.entities.Entity;
import com.SimpleWebShop.integration.entities.ShoeEntity;

@Component
public class DBObjectsFactory {

	List<Entity> populateCars() {
		List<Entity> entities = new ArrayList<Entity>();
		Entity user = new CarEntity();
		user.setId("1");
		user.setName("Dacia");
		user.setPrice("10000");
		user.setCategory("Car");
		entities.add(user);

		user = new CarEntity();
		user.setId("2");
		user.setName("Mercedes");
		user.setPrice("20000");
		user.setCategory("Car");

		entities.add(user);

		user = new CarEntity();
		user.setId("3");
		user.setName("BMW");
		user.setPrice("18000");
		user.setCategory("Car");
		entities.add(user);
		return entities;
	}

	List<Entity> populateShoes() {
		List<Entity> entities = new ArrayList<Entity>();
		Entity user = new ShoeEntity();
		user.setId("1");
		user.setName("Adidas");
		user.setPrice("110");
		user.setCategory("Shoe");

		entities.add(user);

		user = new ShoeEntity();
		user.setId("2");
		user.setName("Nike");
		user.setPrice("221");
		user.setCategory("Shoe");

		entities.add(user);

		user = new ShoeEntity();
		user.setId("3");
		user.setName("Converse");
		user.setPrice("180");
		entities.add(user);
		user.setCategory("Shoe");
		return entities;

	}

	List<Entity> populateDiamonds() {
		List<Entity> entities = new ArrayList<Entity>();
		Entity user = new DiamondEntity();
		user.setId("1");
		user.setName("KOH-I-NOOR");
		user.setPrice("5500000");
		user.setCategory("Diamond");

		entities.add(user);

		user = new DiamondEntity();
		user.setId("2");
		user.setName("The Cullinan");
		user.setPrice("4200000");
		user.setCategory("Diamond");

		entities.add(user);

		user = new DiamondEntity();
		user.setId("3");
		user.setName("The Star of Africa");
		user.setPrice("2100000");
		user.setCategory("Diamond");

		entities.add(user);
		return entities;
	}
}
