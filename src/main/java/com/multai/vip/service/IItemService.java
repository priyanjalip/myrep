package com.multai.vip.service;

import com.multai.vip.bean.Item;
import java.util.List;
import javax.transaction.Transactional;
import org.springframework.stereotype.Component;

@Component
@Transactional
public interface IItemService {
  Item findByItemId(int paramInt);
  
  List<Item> findAllItem();
  
  List<Item> findAllByUserIdAndRestaurantId(int paramInt, long paramLong);
  
  void deleteById(int paramInt);
  
  int saveItem(Item paramItem);
  
  String updateItem(Item paramItem);
}
