package com.example.wmsserver.controller;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.wmsserver.model.Customer;
import com.example.wmsserver.model.Order;
import com.example.wmsserver.model.OrderProduct;
import com.example.wmsserver.model.Product;
import com.example.wmsserver.repository.CustomerRepository;
import com.example.wmsserver.repository.OrderProductRepository;
import com.example.wmsserver.repository.OrderRepository;
import com.example.wmsserver.repository.ProductRepository;

/**
 * @author Apostolos Kouzoukos
 */
@RestController
@RequestMapping("/api")
public class OrderController 
{
	@Autowired
	OrderRepository orderRepository;
	
	@Autowired
	CustomerRepository customerRepository;
	
	@Autowired
	ProductRepository productRepository;
	
	@Autowired
	OrderProductRepository orderProductRepository;

	//WORKS
	@GetMapping("/orders")
	public List<Order> getAllOrders() 
    {
        return orderRepository.findAll();
    }
	
	//WORKS
	@GetMapping("/customers/{customerId}/orders")
    public List<Order> getAllOrdersByCustomerId(@PathVariable(value = "customerId") String customerId)
	{
        return orderRepository.findByCustomerId(customerId);
    }
	
	//WORKS
	@PostMapping("/customers/{customerId}/orders")
    public Order createOrder(@PathVariable(value = "customerId") String customerId, @Valid @RequestBody Order order)
    {		
		Customer customer = customerRepository.findById(customerId).orElseThrow(() -> null);
		
		order.setCustomer(customer);
		
		return orderRepository.save(order);
    }
	
	//WORKS
	@PutMapping("/customers/{customerId}/orders/{orderId}")
    public Order updateOrder(@PathVariable(value = "customerId") String customerId, @PathVariable(value = "orderId") Long orderId, @Valid @RequestBody Order orderRequest) 
	{
		Order order = orderRepository.findById(orderId).orElseThrow(() -> null);
		List<OrderProduct> orderProducts = orderProductRepository.findByOrderId(orderId);
		List<Product> updatedProducts = new ArrayList<Product>();
		
		order.setState(orderRequest.getState());
		
		for(OrderProduct orderProduct: orderProducts)
		{
			int quantity = orderProduct.getQuantity();
			Product product = orderProduct.getProduct();
			
			product.setStock(product.getStock() - quantity);
			
			updatedProducts.add(product);
		}
		
		productRepository.saveAll(updatedProducts);
		
		return orderRepository.save(order);
    }
	
	//WORKS
	@DeleteMapping("/customers/{customerId}/orders/{orderId}")
    public ResponseEntity<?> deleteOrder(@PathVariable(value = "customerId") String customerId, @PathVariable(value = "orderId") Long orderId) 
    {
		List<OrderProduct> orderProducts = orderProductRepository.findByOrderId(orderId);
		Order order = orderRepository.findByIdAndCustomerId(orderId, customerId).orElseThrow(() -> null);
		
		orderProductRepository.deleteAll(orderProducts);
		orderRepository.delete(order);
		
		return ResponseEntity.ok().build();
    }
}