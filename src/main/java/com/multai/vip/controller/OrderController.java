package com.multai.vip.controller;

import com.multai.vip.bean.Order;
import com.multai.vip.service.IOrderService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping({"/order"})
public class OrderController {
  @Autowired
  IOrderService orderService;
  
  @GetMapping({"/order"})
  public String getOrder() {
    return "order";
  }
  
  @GetMapping({"/getAllByUserId/{userId}"})
  public List<Order> getOrderByUserId(@PathVariable int userId) {
    return this.orderService.getAllOrderByUserId(userId);
  }
  
  @GetMapping({"/getOrderByOrderId/{orderId}"})
  public Order getOrderByOrderId(@PathVariable Long orderId) {
    return this.orderService.getOrderByOrderId(orderId);
  }
  
  @GetMapping({"/getAllOrders"})
  public List<Order> getAll() {
    return this.orderService.getAll();
  }
  
  
  @GetMapping({"/add/{orderId}/{orderDate}/{invoiceId}/{invoiceDate}/{itemName}/{finalprice}/{totalPrice}/{userId}/"
  		+ "{addressId}/{email}/{restMailId}/{quantity}"})
  public String addOrder(@PathVariable Long orderId, @PathVariable String orderDate, @PathVariable String invoiceId, @PathVariable String invoiceDate, @PathVariable String itemName,
		  @PathVariable int finalprice,@PathVariable String totalPrice, @PathVariable int userId, @PathVariable int addressId, @PathVariable String email,@PathVariable String restMailId, @PathVariable String quantity) {
    Order order = new Order();
    order.setInvoiceDate(invoiceDate);
    order.setInvoiceId(invoiceId);
    order.setUserId(userId);
    order.setTotalPrice(totalPrice);
    order.setOrderDate(orderDate);
    order.setOrderId(orderId);
    order.setItemName(itemName);
    order.setAddressId(addressId);
    order.setEmail(email);
    order.setQuantity(quantity);
    order.setFinalprice(finalprice);
    order.setRestMailId(restMailId);
    System.out.println(order);
    this.orderService.addOrder(order);
    return "Order Placed Successfully";
  }
  
  @GetMapping({"/update/{orderId}/{invoiceId}/{email}/{restMailId}/{status}"})
  public String updateStatus(@PathVariable Long orderId, @PathVariable String invoiceId, @PathVariable String email,@PathVariable String restMailId,@PathVariable String status) {
    this.orderService.updateStatus(orderId, invoiceId, email,restMailId,status);
    return "Order Cancelled";
  }
}
