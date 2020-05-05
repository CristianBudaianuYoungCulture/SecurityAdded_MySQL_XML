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
import com.SimpleWebShop.integration.entities.Entity;
import com.SimpleWebShop.integration.entities.Person;
import com.SimpleWebShop.integration.repo.PersonRepository;
import com.SimpleWebShop.integration.repo.ProductRepository;
import com.SimpleWebShop.integration.repo.dao.CustomerDAO;
import com.SimpleWebShop.integration.repo.entity.Customer;
import com.SimpleWebShop.utility.WebShopUtilityClass;

@Controller
public class HomeController {

	@Autowired
	private ProductRepository productRepositoryBean;
	@Autowired
	private CustomerDAO customerDAOImpl;
	@Autowired
	PersonRepository<Person> personRepository;

	@RequestMapping(value = "/")
	public ModelAndView index(HttpServletResponse response) throws IOException {
		return new ModelAndView("home");
	}

	@RequestMapping(value = "/items")
	public void listItems(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		String item = request.getParameter("item");
		List<Entity> items;
		Iterable<Person> findAll = personRepository.findAll();

		List<Customer> customers = customerDAOImpl.getCustomers();
		if ("emptycart".equals(item)) {
			productRepositoryBean.emptyCart();
			items = new ArrayList<>();
		} else if ("cart".equals(item)) {
			items = productRepositoryBean.retriveCartProducts(item);
		} else {
			items = productRepositoryBean.retriveProducts(item);
		}

		request.setAttribute("products", items);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/");
		dispatcher.forward(request, response);
	}

	@RequestMapping(value = "/cart/item", method = { RequestMethod.POST })
	@ResponseBody
	public String addToCart(@RequestParam Map<String, Object> body) {
		CartEntity cartEntity = new CartEntity();
		WebShopUtilityClass.mapBodyToEntity(body, cartEntity);
		productRepositoryBean.updateCartDataBase(cartEntity);
		return "Added";
	}

}
