package com.multai.vip.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.multai.vip.bean.Order;

@Repository
public interface IOrderDAO extends JpaRepository<Order, Long> {

	public Order findByOrderId(int orderId);
	
	public Order findByOrderId(Long orderId);

	public List<Order> findAllByUserId(int userId);

	public Order findByInvoiceId(String invoiceId);
	
}
