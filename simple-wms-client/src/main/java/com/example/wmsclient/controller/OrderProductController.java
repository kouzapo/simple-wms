package com.example.wmsclient.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.client.RestTemplate;

import com.example.wmsclient.model.OrderProduct;

@Controller
public class OrderProductController 
{
	@Autowired
	static RestTemplate restTemplate = new RestTemplate();
	
	public static OrderProduct[] getAllProductsByOrderId(String orderId)
	{
		String url = "http://192.168.1.7:8080/api/orders/" + orderId + "/order_products";
		
		return restTemplate.getForObject(url, OrderProduct[].class);
	}
	
	public static OrderProduct[] addProducts(String orderId, List<OrderProduct> orderProducts)
	{
		String url = "http://192.168.1.7:8080/api/orders/" + orderId + "/order_products";
		
		return restTemplate.postForObject(url, orderProducts, OrderProduct[].class);
	}
	
	
}