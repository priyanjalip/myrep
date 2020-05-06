package com.multai.vip.service;

import com.multai.vip.bean.Order;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public interface IOrderService {
	Order getOrderByOrderId(Long paramInt);

	List<Order> getAllOrderByUserId(int paramInt);

	List<Order> getAll();

	void addOrder(Order paramOrder);

	void updateStatus(Long paramLong, String paramString1, String paramString2, String paramString3,String status);

	void updateOrder(Order order);
}
