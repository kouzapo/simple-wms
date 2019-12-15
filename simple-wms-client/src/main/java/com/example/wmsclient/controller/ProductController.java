package com.example.wmsclient.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.client.RestTemplate;

import com.example.wmsclient.model.Product;
import com.example.wmsclient.util.Consts;

@Controller
public abstract class ProductController 
{
	@Autowired
	static RestTemplate restTemplate = new RestTemplate();
	
	static final String URL = Consts.ADDRESS + ":" + Consts.PORT;
	
	//WORKS
	public static Product[] getAllProducts()
	{
		return restTemplate.getForObject(URL + "/api/products/", Product[].class);
	}
	
	//WORKS
	public static Product getProductById(String id)
	{	
		return restTemplate.getForObject(URL + "/api/products/" + id, Product.class);
	}
	
	//WORKS
	public static Product createProduct(Product product)
	{	
		return restTemplate.postForObject(URL + "/api/products/", product, Product.class);
	}
	
	//WORKS
	public static Product updateProduct(String id, Product product)
	{	
		restTemplate.put(URL + "/api/products/" + id, product);
		
		return product;
	}
	
	//WORKS
	public static ResponseEntity<?> deleteProduct(String id)
	{
		restTemplate.delete(URL + "/api/products/" + id);
		
		return ResponseEntity.ok().build();
	}
}