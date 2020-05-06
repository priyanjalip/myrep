package com.multai.vip.service;

import com.multai.vip.bean.Item;
import com.multai.vip.dao.ItemDao;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ItemService implements IItemService {
  @Autowired
  ItemDao itemDao;
  
  public Item findByItemId(int itemId) {
    return itemDao.findByItemId(itemId);
  }
  
  public List<Item> findAllByUserIdAndRestaurantId(int userId, long restaurantId) {
    return itemDao.findAllByUserIdAndRestaurantId(userId, restaurantId);
  }
  
  public void deleteById(int itemId) {
    itemDao.deleteById(itemId);
  }
  
  public int saveItem(Item item) {
    itemDao.save(item);
    int itemId = ((Item)this.itemDao.findAll().get(this.itemDao.findAll().size() - 1)).getItemId();
    System.out.println(itemId);
    return itemId;
  }
  
  public String updateItem(Item item) {
    itemDao.saveAndFlush(item);
    return "Item updated Successfully";
  }
  
  public List<Item> findAllItem() {
    return this.itemDao.findAll();
  }
}
