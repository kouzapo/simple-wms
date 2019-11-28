package com.example.wmsserver.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.wmsserver.model.Product;

/**
 * @author Apostolos Kouzoukos
 */
@Repository
public interface ProductRepository extends JpaRepository<Product, Long>
{
	
}