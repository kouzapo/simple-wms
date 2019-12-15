package com.example.wmsclient.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.client.RestTemplate;

import com.example.wmsclient.model.Order;
import com.example.wmsclient.util.Consts;

@Controller
public abstract class OrderController 
{
	@Autowired
	static RestTemplate restTemplate = new RestTemplate();
	
	static final String URL = Consts.ADDRESS + ":" + Consts.PORT;
	
	//WORKS
	public static Order[] getAllOrders()
	{	
		return restTemplate.getForObject(URL + "/api/orders/", Order[].class);
	}
	
	//WORKS
	public static Order[] getAllOrdersByCustomerId(String customerId)
	{	
		return restTemplate.getForObject(URL + "/api/customers/" + customerId + "/orders", Order[].class);
	}
	
	//WORKS
	public static Order createOrder(String customerId, Order order)
	{	
		return restTemplate.postForObject(URL + "/api/customers/" + customerId + "/orders", order, Order.class);
	}
	
	//WORKS
	public static Order updateOrder(String customerId, String orderId, Order order)
	{
		String url = "http://192.168.1.7:8080/api/customers/" + customerId + "/orders/" + orderId;
		
		
		
		return restTemplate.put(url, order);
	}
	
	//WORKS
	public static ResponseEntity<?> deleteOrder(String customerId, String orderId)
	{
		String url = "http://192.168.1.7:8080/api/customers/" + customerId + "/orders/" + orderId;
		
		restTemplate.delete(url);
		
		return ResponseEntity.ok().build();
	}
}