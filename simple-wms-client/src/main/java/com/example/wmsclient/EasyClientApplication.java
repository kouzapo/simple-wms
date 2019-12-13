package com.example.wmsclient;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.wmsclient.controller.CustomerController;
import com.example.wmsclient.controller.OrderProductController;
import com.example.wmsclient.controller.ProductController;
import com.example.wmsclient.model.Customer;
import com.example.wmsclient.model.OrderProduct;
import com.example.wmsclient.model.Product;

/**
 * @author Apostolos Kouzoukos
 * @version 1.0
 */
@SpringBootApplication
public class EasyClientApplication implements CommandLineRunner
{
	public static void main(String[] args)
	{
		SpringApplication.run(EasyClientApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception 
	{

		
		
		
	}
}