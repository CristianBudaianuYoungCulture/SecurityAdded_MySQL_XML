package com.SimpleWebShop.config;

import java.sql.Connection;
import java.sql.DriverManager;

import javax.servlet.ServletException;

import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.concurrent.ConcurrentMapCacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableCaching
public class CachingConfig {
//Commit 1
	@Bean
	public CacheManager cacheManager() throws ServletException {
		System.out.println("ssss Cache is initialized!");
		// setup connection variables
		String user = "cristianBudaianu";
		String pass = "cristianBudaianu";

		String jdbcUrl = "jdbc:mysql://localhost:3306/web_customer_tracker?useSSL=false";
		String driver = "com.mysql.cj.jdbc.Driver";

		// get connection to database
		try {

			System.out.println("Connecting to database: " + jdbcUrl);

			Class.forName(driver);

			Connection myConn = DriverManager.getConnection(jdbcUrl, user, pass);

			System.out.println(myConn);
			System.out.println("SUCCESS!!!");

			myConn.close();

		} catch (Exception exc) {
			exc.printStackTrace();
			throw new ServletException(exc);
		}
		return new ConcurrentMapCacheManager("products");
	}
}