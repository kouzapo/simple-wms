package com.example.wmsserver.controller;

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
import com.example.wmsserver.repository.CustomerRepository;

/**
 * @author Apostolos Kouzoukos
 */
@RestController
@RequestMapping("/api")
public class CustomerController 
{
	@Autowired
	CustomerRepository customerRepository;
	
	//WORKS
	@GetMapping("/customers")
    public List<Customer> getAllCustomers() 
    {
        return customerRepository.findAll();
    }
	
	//WORKS
	@GetMapping("/customers/{id}")
    public Customer getCustomerById(@PathVariable(value = "id") String customerId)
    {
        return customerRepository.findById(customerId).orElseThrow(() -> null);
    }
	
	//WORKS
	@PostMapping("/customers")
	public Customer createCustomer(@Valid @RequestBody Customer customer)
    {
        return customerRepository.save(customer);
    }
	
	//WORKS
	@PutMapping("/customers/{id}")
    public Customer updateCustomer(@PathVariable(value = "id") String customerId, @Valid @RequestBody Customer updatedCustomer)
    {
		Customer customer = customerRepository.findById(customerId).orElseThrow(() -> null);
		
		customer.setName(updatedCustomer.getName());
		customer.setEmail(updatedCustomer.getEmail());
		customer.setAddress(updatedCustomer.getAddress());
		customer.setPhoneNumber(updatedCustomer.getPhoneNumber());
		
		return customerRepository.save(customer);
    }
	
	//WORKS
	@DeleteMapping("/customers/{id}")
    public ResponseEntity<?> deleteCustomer(@PathVariable(value = "id") String customerId)
    {
        Customer customer = customerRepository.findById(customerId).orElseThrow(() -> null);

        customerRepository.delete(customer);

        return ResponseEntity.ok().build();
    }
}