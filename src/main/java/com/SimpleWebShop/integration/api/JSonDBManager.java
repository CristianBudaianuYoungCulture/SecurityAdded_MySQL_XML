package com.SimpleWebShop.integration.api;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Component;

import com.SimpleWebShop.integration.entities.CarEntity;
import com.SimpleWebShop.integration.entities.CartEntity;
import com.SimpleWebShop.integration.entities.DiamondEntity;
import com.SimpleWebShop.integration.entities.Entity;
import com.SimpleWebShop.integration.entities.ShoeEntity;
import com.SimpleWebShop.utility.WebShopConstants;
import com.fasterxml.jackson.databind.ObjectMapper;

@Component
public class JSonDBManager {

	private ObjectMapper mapper = new ObjectMapper();

	void initilizeJSonDataBase(String path, List<Entity> entities) {

		try {
			File resultFile = new File(path);
			mapper.writeValue(resultFile, entities);

		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	void updateCartDataBase(String cartPath, CartEntity cartEntity) {
		File file = new File(cartPath);
		List<Entity> entities = new ArrayList<Entity>();

		if (file.length() != 0) {
			try {
				entities = readJSonDataBase("cart", cartPath);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		try {
			List<Entity> newEntities = new ArrayList<Entity>(entities);
			newEntities.add(cartEntity);
			emptyJSonDataBase(cartPath);
			mapper.writeValue(file, newEntities);

		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	List<Entity> readJSonDataBase(String category, String path) throws IOException {
		Class<? extends Entity[]> type;
		File file = new File(path);

		if (path.contains("cart_Table") && file.length() == 0) {
			return new ArrayList<Entity>();
		}
		if (WebShopConstants.DIAMONDS.equals(category)) {
			type = DiamondEntity[].class;
		} else if (WebShopConstants.CARS.equals(category)) {
			type = CarEntity[].class;
		} else if (WebShopConstants.SHOES.equals(category)) {
			type = ShoeEntity[].class;
		} else {
			type = CartEntity[].class;
		}
		Entity[] entities = mapper.readValue(new File(path), type);
		return Arrays.asList(entities);
	}

	public void emptyJSonDataBase(String cartPath) {
		File file = new File(cartPath);
		file.delete();
	}

}
