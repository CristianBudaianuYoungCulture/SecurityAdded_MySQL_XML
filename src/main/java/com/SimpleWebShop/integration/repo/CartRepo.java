package com.SimpleWebShop.integration.repo;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Repository;

import com.SimpleWebShop.integration.entities.CartEntity;
import com.SimpleWebShop.integration.entities.ProductEntity;

@Repository
public class CartRepo<T> {

	@Autowired
	CartDAO cartDAO;

	public void deleteAllForUser() {
		int i = cartDAO.deleteByUser(extractUserName());
		System.out.println(i);
	}

	public List<ProductEntity> retriveAllForUser() {
		List<CartEntity> listOfCartEntity = cartDAO.findByUser(extractUserName());
		ArrayList<ProductEntity> result = new ArrayList<>();
		for (CartEntity cartEntity : listOfCartEntity) {

			result.add(cartToProduct(cartEntity));
		}
		return result;
	}

	private ProductEntity cartToProduct(CartEntity cartEntity) {
		ProductEntity productEntity = new ProductEntity();
		productEntity.setCategory(cartEntity.getCategory());
		productEntity.setName(cartEntity.getName());
		productEntity.setPrice(cartEntity.getPrice());
		return productEntity;
	}

	private CartEntity productToCart(ProductEntity productEntity) {
		String userName = extractUserName();
		CartEntity cartEntity = new CartEntity();
		cartEntity.setCategory(productEntity.getCategory());
		cartEntity.setName(productEntity.getName());
		cartEntity.setPrice(productEntity.getPrice());
		cartEntity.setId(productEntity.getId());

		cartEntity.setUser(userName);

		return cartEntity;
	}

	public void addProductToCart(ProductEntity productEntity) {
		cartDAO.save(productToCart(productEntity));

	}

	private String extractUserName() {
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		String username;
		if (principal instanceof UserDetails) {
			username = ((UserDetails) principal).getUsername();
		} else {
			username = principal.toString();
		}
		return username;
	}

}
