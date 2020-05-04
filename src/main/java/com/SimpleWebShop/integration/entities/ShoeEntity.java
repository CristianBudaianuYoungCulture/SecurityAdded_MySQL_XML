package com.SimpleWebShop.integration.entities;

public class ShoeEntity implements Entity {

	private String id;
	private String name;
	private String price;
	private String category;

	@Override
	public String getId() {
		return id;
	}

	@Override
	public String getCategory() {
		return category;
	}

	@Override
	public void setCategory(String description) {
		this.category = description;
	}

	@Override
	public void setId(String id) {
		this.id = id;
	}

	@Override
	public String getName() {
		return name;
	}

	@Override
	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String getPrice() {
		return price;
	}

	@Override
	public void setPrice(String price) {
		this.price = price;
	}
}
