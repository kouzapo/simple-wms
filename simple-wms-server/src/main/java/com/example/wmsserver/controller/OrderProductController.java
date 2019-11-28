package com.example.wmsserver.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.wmsserver.model.Order;
import com.example.wmsserver.model.OrderProduct;
import com.example.wmsserver.repository.OrderProductRepository;
import com.example.wmsserver.repository.OrderRepository;

/**
 * @author Apostolos Kouzoukos
 */
@RestController
@RequestMapping("/api")
public class OrderProductController 
{
	@Autowired
	OrderProductRepository orderProductRepository;
	
	@Autowired
	OrderRepository orderRepository;
	
	//WORKS
	@GetMapping("/orders/{orderId}/order_products")
	public List<OrderProduct> getAllProductsByOrderId(@PathVariable(value = "orderId") Long orderId)
	{
		return orderProductRepository.findByOrderId(orderId);
	}
	
	//WORKS
	@PostMapping("/orders/{orderId}/order_products")
	public List<OrderProduct> addProducts(@PathVariable(value = "orderId") Long orderId, @Valid @RequestBody List<OrderProduct> orderProducts)
	{
		Order order = orderRepository.findById(orderId).orElseThrow(() -> null);
		
		for(OrderProduct orderProduct: orderProducts)
			orderProduct.setOrder(order);
		
		return orderProductRepository.saveAll(orderProducts);
	}
	
	//WORKS
	@DeleteMapping("/orders/{orderId}/order_products/{orderProductId}")
	public ResponseEntity<?> deleteProductFromOrder(@PathVariable(value = "orderId") Long orderId, @PathVariable(value = "orderProductId") Long orderProductId)
	{
		OrderProduct orderProduct = orderProductRepository.findById(orderProductId).orElseThrow(() -> null);
		
		orderProductRepository.delete(orderProduct);
		
		return ResponseEntity.ok().build();
	}
}