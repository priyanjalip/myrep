package com.multai.vip.service;

import com.multai.vip.bean.Restaurant;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public interface IRestaurantService {
  Restaurant getRestaurantById(long paramLong);
  
  Restaurant getRestaurantByUserId(int paramInt);
  
  long saveRestaurant(Restaurant paramRestaurant);
  
  List<Restaurant> getAllRestaurant();
  
  void deleteRestaurantByRestaurantId(long restaurantId);
  
  void updateRestaurant(Restaurant paramRestaurant);
}
