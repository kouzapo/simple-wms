package com.example.wmsserver.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.wmsserver.model.Order;

/**
 * @author Apostolos Kouzoukos
 */
@Repository
public interface OrderRepository extends JpaRepository<Order, Long>
{
	List<Order> findByCustomerId(String customerId);
	Optional<Order> findByIdAndCustomerId(Long id, String customerId);
}