package com.SimpleWebShop.config;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.SimpleWebShop.integration.repo.ProductRepository;

@Component
public class DataBaseInitializing implements InitializingBean {

	@Autowired
	private ProductRepository productRepositoryBean;

	@Override
	public void afterPropertiesSet() {
		System.out.println("Data Base is initialized!");
		productRepositoryBean.initializeDataBase();

	}

}
