package com.example.wmsclient.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.client.RestTemplate;

import com.example.wmsclient.model.Product;

@Controller
public abstract class ProductController 
{
	@Autowired
	static RestTemplate restTemplate = new RestTemplate();
	
	static final String URL = "http://192.168.1.7:8080/";
	
	//WORKS
	public static Product[] getAllProducts()
	{
		String url = "http://192.168.1.7:8080/api/products/";
		
		return restTemplate.getForObject(url, Product[].class);
	}
	
	//WORKS
	public static Product getProductById(String id)
	{
		String url = "http://192.168.1.7:8080/api/products/" + id;
		
		return restTemplate.getForObject(url, Product.class);
	}
	
	//WORKS
	public static Product createProduct(Product product)
	{
		String url = "http://192.168.1.7:8080/api/products/";
		
		return restTemplate.postForObject(url, product, Product.class);
	}
	
	//WORKS
	public static Product updateProduct(String id, Product product)
	{
		String url = "http://192.168.1.7:8080/api/products/" + id;
		
		restTemplate.put(url, product);
		
		return product;
	}
	
	//WORKS
	public static ResponseEntity<?> deleteProduct(String id)
	{
		String url = "http://192.168.1.7:8080/api/products/" + id;
		
		restTemplate.delete(url);
		
		return ResponseEntity.ok().build();
	}
}