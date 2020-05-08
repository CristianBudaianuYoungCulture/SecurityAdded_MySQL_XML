package com.SimpleWebShop.utility;

import java.util.Map;

import com.SimpleWebShop.integration.entities.ProductEntity;

public class WebShopUtilityClass {
	public static void mapBodyToEntity(Map<String, Object> body, ProductEntity productEntity) {
		productEntity.setId(Integer.valueOf((String) body.get("id")));
		productEntity.setName((String) body.get("name"));
		productEntity.setCategory((String) body.get("category"));
		productEntity.setPrice((String) body.get("price"));
	}
}
