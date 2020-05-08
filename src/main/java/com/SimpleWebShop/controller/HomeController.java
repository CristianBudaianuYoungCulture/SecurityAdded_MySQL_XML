package com.SimpleWebShop.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.SimpleWebShop.integration.entities.CartEntity;
import com.SimpleWebShop.integration.entities.Customer;
import com.SimpleWebShop.integration.entities.Person;
import com.SimpleWebShop.integration.entities.ProductEntity;
import com.SimpleWebShop.integration.repo.CartRepo;
import com.SimpleWebShop.integration.repo.CustomerDAOSimpleJPA;
import com.SimpleWebShop.integration.repo.ProductRepo;
import com.SimpleWebShop.utility.WebShopUtilityClass;

@Controller
public class HomeController {

	@Autowired
	private ProductRepo<Person> productRepository;
	@Autowired
	private CartRepo<CartEntity> cartRepository;

	@Autowired
	private CustomerDAOSimpleJPA customerDAOSimpleJPA;

	@RequestMapping(value = "/")
	public ModelAndView index(HttpServletResponse response) throws IOException {
		return new ModelAndView("home");
	}

	@RequestMapping(value = "/items")
	public void listItems(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		String item = request.getParameter("item");
		List<ProductEntity> items = null;

		List<Customer> customers = customerDAOSimpleJPA.getCustomers();
		if ("emptycart".equals(item)) {
			cartRepository.deleteAllForUser();
			items = new ArrayList<>();
		} else if ("cart".equals(item)) {
			items = cartRepository.retriveAllForUser();
		} else {
			System.out.println("button pressed");
			items = productRepository.findByCategory(item);
		}

		request.setAttribute("products", items);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/");
		dispatcher.forward(request, response);
	}

	@RequestMapping(value = "/cart/item", method = { RequestMethod.POST })
	@ResponseBody
	public String addToCart(@RequestParam Map<String, Object> body) {
		ProductEntity productEntity = new ProductEntity();
		WebShopUtilityClass.mapBodyToEntity(body, productEntity);
		cartRepository.addProductToCart(productEntity);
		return "Added";
	}

}
