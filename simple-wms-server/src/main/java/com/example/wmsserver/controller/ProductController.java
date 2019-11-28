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

import com.example.wmsserver.model.Product;
import com.example.wmsserver.repository.ProductRepository;

/**
 * @author Apostolos Kouzoukos
 */
@RestController
@RequestMapping("/api")
public class ProductController 
{
	@Autowired
    ProductRepository productRepository;
	
	//WORKS
	@GetMapping("/products")
    public List<Product> getAllProducts() 
    {
        return productRepository.findAll();
    }
	
	//WORKS
	@GetMapping("/products/{id}")
    public Product getProductById(@PathVariable(value = "id") Long productId)
    {
        return productRepository.findById(productId).orElseThrow(() -> null);
    }

	//WORKS
	@PostMapping("/products")
	public Product createProduct(@Valid @RequestBody Product product)
    {
        return productRepository.save(product);
    }

	//WORKS
	@PutMapping("/products/{id}")
    public Product updateProduct(@PathVariable(value = "id") Long productId, @Valid @RequestBody Product updatedProduct)
    {
		Product product = productRepository.findById(productId).orElseThrow(() -> null);
		
		product.setName(updatedProduct.getName());
		product.setQuality(updatedProduct.getQuality());
		product.setPackaging(updatedProduct.getPackaging());
		product.setStock(updatedProduct.getStock());
		
		return productRepository.save(product);
    }

	//WORKS
	@DeleteMapping("/products/{id}")
    public ResponseEntity<?> deleteProduct(@PathVariable(value = "id") Long productId)
    {
        Product product = productRepository.findById(productId).orElseThrow(() -> null);

        productRepository.delete(product);

        return ResponseEntity.ok().build();
    }
}