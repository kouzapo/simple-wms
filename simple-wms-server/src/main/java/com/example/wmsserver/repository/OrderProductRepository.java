package com.example.wmsserver.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.wmsserver.model.OrderProduct;

/**
 * @author Apostolos Kouzoukos
 */
@Repository
public interface OrderProductRepository extends JpaRepository<OrderProduct, Long>
{
	List<OrderProduct> findByOrderId(Long orderId);
}