package com.SimpleWebShop.integration.entities;

public class DiamondEntity implements Entity {

	private String id;
	private String name;
	private String price;
	private String description;

	@Override
	public String getId() {
		return id;
	}

	@Override
	public void setId(String id) {
		this.id = id;
	}

	@Override
	public String getCategory() {
		return description;
	}

	@Override
	public void setCategory(String description) {
		this.description = description;
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
