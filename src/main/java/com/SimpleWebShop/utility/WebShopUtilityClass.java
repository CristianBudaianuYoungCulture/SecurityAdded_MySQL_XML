package com.SimpleWebShop.utility;

import java.util.Map;

import com.SimpleWebShop.integration.entities.CartEntity;

public class WebShopUtilityClass {
	public static void mapBodyToEntity(Map<String, Object> body, CartEntity cartEntity) {
		cartEntity.setId((String) body.get("id"));
		cartEntity.setName((String) body.get("name"));
		cartEntity.setCategory((String) body.get("category"));
		cartEntity.setPrice((String) body.get("price"));
	}
}
