package com.multai.vip.controller;

import com.multai.vip.bean.Item;
import com.multai.vip.dao.ImageRepository;
import com.multai.vip.service.IItemService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping({"item"})
public class ItemController {
  @Autowired
  IItemService itemService;
  
  @Autowired
  ImageRepository imageRepository;
  
  
  @GetMapping({"/get/{itemId}"})
  public Item findByItemId(@PathVariable int itemId) {
    return this.itemService.findByItemId(itemId);
  }
  
  @GetMapping({"/getAll"})
  public List<Item> findAll() {
    return this.itemService.findAllItem();
  }
  
  @GetMapping({"/getAllBy/{userId}/{restaurantId}"})
  public List<Item> findAllByUserIdAndRestaurantId(@PathVariable int userId, @PathVariable long restaurantId) {
    return this.itemService.findAllByUserIdAndRestaurantId(userId, restaurantId);
  }
  
  @GetMapping({"/delete/{itemId}"})
  public String deleteById(@PathVariable int itemId) {
    this.itemService.deleteById(itemId);
    Long id=imageRepository.findByItemId(itemId).get().getId();
    imageRepository.deleteById(id);
    return "Item Deleted Successfully";
  }
//  
//  @GetMapping({"/add/{userId}/{itemId}/{itemName}/{itemType}/{itemPrice}/{restaurantId}"})
//  public int saveItem(@PathVariable int userId, @PathVariable int itemId, @PathVariable String itemName, @PathVariable String itemType, @PathVariable int itemPrice, @PathVariable long restaurantId) {
//
//    Item item = new Item();
//    item.setItemId(itemId);
//    item.setItemName(itemName);
//    item.setItemPrice(itemPrice);
//    item.setItemType(itemType);
//    item.setRestaurantId(restaurantId);
//    item.setUserId(userId);
//    return this.itemService.saveItem(item);
//  }
  
  @GetMapping({"/addFood/{userId}/{itemId}/{itemName}/{itemType}/{itemPrice}/{restaurantId}/{type}"})
  public int addFood(@PathVariable int userId, @PathVariable int itemId, @PathVariable String itemName, @PathVariable String itemType, @PathVariable int itemPrice, @PathVariable long restaurantId, @PathVariable String type) {

    Item item = new Item();
    item.setItemId(itemId);
    item.setItemName(itemName);
    item.setItemPrice(itemPrice);
    item.setItemType(itemType);
    item.setRestaurantId(restaurantId);
    item.setUserId(userId);
    item.setType(type);
    return this.itemService.saveItem(item);
  }
//  
//  @GetMapping({"/update/{userId}/{itemId}/{itemName}/{itemType}/{itemPrice}/{restaurantId}"})
//  public String updateAddress(@PathVariable int userId, @PathVariable int itemId, @PathVariable String itemName, @PathVariable String itemType, @PathVariable int itemPrice, @PathVariable long restaurantId) {
//    Item item = new Item();
//    item.setItemId(itemId);
//    item.setItemName(itemName);
//    item.setItemPrice(itemPrice);
//    item.setItemType(itemType);
//    item.setRestaurantId(restaurantId);
//    item.setUserId(userId);
//    return this.itemService.updateItem(item);
//  }
  
  @GetMapping({"/updateFood/{userId}/{itemId}/{itemName}/{itemType}/{itemPrice}/{restaurantId}/{type}"})
  public String updateFood(@PathVariable int userId, @PathVariable int itemId, @PathVariable String itemName, @PathVariable String itemType, @PathVariable int itemPrice, @PathVariable long restaurantId, @PathVariable String type) {
    Item item = new Item();
    item.setItemId(itemId);
    item.setItemName(itemName);
    item.setItemPrice(itemPrice);
    item.setItemType(itemType);
    item.setRestaurantId(restaurantId);
    item.setUserId(userId);
    item.setType(type);
    return this.itemService.updateItem(item);
  }
}
