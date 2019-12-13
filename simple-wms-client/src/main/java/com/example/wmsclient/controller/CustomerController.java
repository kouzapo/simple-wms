package com.example.wmsclient.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.client.RestTemplate;

import com.example.wmsclient.model.Customer;

@Controller
public abstract class CustomerController 
{
	@Autowired
	static RestTemplate restTemplate = new RestTemplate();
	
	static final String URL = "http://192.168.1.7:8080/";
	
	//WORKS
	public static Customer[] getAllCustomers()
	{
		String url = "http://192.168.1.7:8080/api/customers/";
		
		return restTemplate.getForObject(url, Customer[].class);
	}
	
	//WORKS
	public static Customer getCustomerById(String id)
	{
		String url = "http://192.168.1.7:8080/api/customers/" + id;
		
		return restTemplate.getForObject(url, Customer.class);
	}
	
	//WORKS
	public static Customer createCustomer(Customer customer)
	{
		String url = "http://192.168.1.7:8080/api/customers/";
		
		return restTemplate.postForObject(url, customer, Customer.class);
	}
	
	//WORKS
	public static Customer updateCustomer(String id, Customer customer)
	{
		String url = "http://192.168.1.7:8080/api/customers/" + id;
		
		restTemplate.put(url, customer);
		
		return customer;
	}
	
	//WORKS
	public static ResponseEntity<?> deleteCustomer(String id)
	{
		String url = "http://192.168.1.7:8080/api/customers/" + id;
		
		restTemplate.delete(url);
		
		return ResponseEntity.ok().build();
	}
}