package com.example.wmsclient.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.client.RestTemplate;

import com.example.wmsclient.model.Order;

@Controller
public abstract class OrderController 
{
	@Autowired
	static RestTemplate restTemplate = new RestTemplate();
	
	//WORKS
	public static Order[] getAllOrders()
	{
		String url = "http://192.168.1.7:8080/api/orders/";
		
		return restTemplate.getForObject(url, Order[].class);
	}
	
	//WORKS
	public static Order[] getAllOrdersByCustomerId(String customerId)
	{
		String url = "http://192.168.1.7:8080/api/customers/" + customerId + "/orders";
		
		return restTemplate.getForObject(url, Order[].class);
	}
	
	//WORKS
	public static Order createOrder(String customerId, Order order)
	{
		String url = "http://192.168.1.7:8080/api/customers/" + customerId + "/orders";
		
		return restTemplate.postForObject(url, order, Order.class);
	}
	
	//WORKS
	public static Order updateOrder(String customerId, String orderId, Order order)
	{
		String url = "http://192.168.1.7:8080/api/customers/" + customerId + "/orders/" + orderId;
		
		restTemplate.put(url, order);
		
		return new Order(orderId, order.getState(), customerId);
	}
	
	//WORKS
	public static ResponseEntity<?> deleteOrder(String customerId, String orderId)
	{
		String url = "http://192.168.1.7:8080/api/customers/" + customerId + "/orders/" + orderId;
		
		restTemplate.delete(url);
		
		return ResponseEntity.ok().build();
	}
}