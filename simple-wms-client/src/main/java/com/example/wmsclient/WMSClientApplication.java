package com.example.wmsclient;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.wmsclient.controller.CustomerController;
import com.example.wmsclient.controller.OrderController;
import com.example.wmsclient.controller.ProductController;
import com.example.wmsclient.model.Customer;
import com.example.wmsclient.model.Order;
import com.example.wmsclient.model.Product;

/**
 * @author Apostolos Kouzoukos
 * @version 1.0
 */
@SpringBootApplication
public class WMSClientApplication implements CommandLineRunner
{
	public static void main(String[] args)
	{
		SpringApplication.run(WMSClientApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception 
	{

		//-----Products-----
		
		/*//GET all products.
		Product products[] = ProductController.getAllProducts();
		
		for(int i = 0; i < products.length; i++)
			System.out.println(products[i].getName());
		
		//GET product by ID.
		Product product = ProductController.getProductById("2");
		
		System.out.println(product.getName());
		
		//POST product.
		Product product = new Product("MELON", "1", "1", 10);
		
		ProductController.createProduct(product);
		
		//PUT product.
		Product product = new Product("CHERRIES", "1", "1", 10);
		
		ProductController.updateProduct("3", product);
		
		//DELETE product.
		ProductController.deleteProduct("13");*/
		
		
		
		
		//-----Customers-----
		
		/*//GET all customers.
		Customer customers[] = CustomerController.getAllCustomers();
		
		for(int i = 0; i < customers.length; i++)
			System.out.println(customers[i].getName());
		
		//GET customer by ID.
		Customer customer = CustomerController.getCustomerById("111111111");
		
		System.err.println(customer.getName());
		
		//POST customer.
		
		Customer customer = new Customer("333333333", "CCC", "ccc@gmail.com", "-", "123123123");
		
		CustomerController.createCustomer(customer);
		
		//PUT customer.
		
		Customer customer = new Customer("000000000", "AABB", "aaa@gmail.com", "-", "123123123");
		
		CustomerController.updateCustomer("000000000", customer);
		
		//DELETE customer.
		CustomerController.deleteCustomer("444444444");*/
		
		
		
		
		//-----Orders-----
		
		/*//GET all orders.
		
		Order[] orders = OrderController.getAllOrders();
		
		for(int i = 0; i < orders.length; i++)
			System.out.println(orders[i].getId());
		
		//GET all orders by customer ID.
		
		Order[] customerOrders = OrderController.getAllOrdersByCustomerId("000000000");
		
		for(int i = 0; i < customerOrders.length; i++)
			System.out.println(customerOrders[i].getId());
		
		//POST order.
		
		Order order = new Order("1");
		
		OrderController.createOrder("000000000", order);*/
		
		//PUT order.
		
		
		
		
		
		
		
	}
}