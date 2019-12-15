package com.example.wmsclient.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.client.RestTemplate;

import com.example.wmsclient.model.Customer;
import com.example.wmsclient.util.Consts;

@Controller
public abstract class CustomerController 
{
	@Autowired
	static RestTemplate restTemplate = new RestTemplate();
	
	static final String URL = Consts.ADDRESS + ":" + Consts.PORT;
	
	//WORKS
	public static Customer[] getAllCustomers()
	{
		return restTemplate.getForObject(URL + "/api/customers/", Customer[].class);
	}
	
	//WORKS
	public static Customer getCustomerById(String id)
	{
		return restTemplate.getForObject(URL + "/api/customers/" + id, Customer.class);
	}
	
	//WORKS
	public static Customer createCustomer(Customer customer)
	{
		return restTemplate.postForObject(URL + "/api/customers/", customer, Customer.class);
	}
	
	//WORKS
	public static Customer updateCustomer(String id, Customer customer)
	{
		restTemplate.put(URL + "/api/customers/" + id, customer);
		
		return customer;
	}
	
	//WORKS
	public static ResponseEntity<?> deleteCustomer(String id)
	{
		restTemplate.delete(URL + "/api/customers/" + id);
		
		return ResponseEntity.ok().build();
	}
}