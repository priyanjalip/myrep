package com.multai.vip.dao;

import com.multai.vip.bean.Item;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemDao extends JpaRepository<Item, Integer> {
  Item findByItemId(int paramInt);
  
  List<Item> findAllByUserIdAndRestaurantId(int paramInt, long paramLong);

}
