package com.multai.vip.service;

import com.multai.vip.bean.Restaurant;
import com.multai.vip.dao.IRestaurantDAO;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Transactional
@Component
public class RestaurantService implements IRestaurantService {
  @Autowired
  IRestaurantDAO restaurantDao;
  
  public Restaurant getRestaurantById(long restaurantId) {
    return this.restaurantDao.findByRestaurantId(restaurantId);
  }
  
  public Restaurant getRestaurantByUserId(int userId) {
    return this.restaurantDao.findByUserId(userId);
  }
  
  public long saveRestaurant(Restaurant restaurant) {
    this.restaurantDao.save(restaurant);
    long restaurantId = ((Restaurant)this.restaurantDao.findAll().get(this.restaurantDao.findAll().size() - 1)).getRestaurantId();
    System.out.println(restaurant);
    return restaurantId;
  }
  
  public List<Restaurant> getAllRestaurant() {
    return this.restaurantDao.findAll();
  }
  
  public void deleteRestaurantByRestaurantId(long restaurantId) {
    restaurantDao.deleteById(restaurantId);
  }
  
  public void updateRestaurant(Restaurant restaurant) {
    this.restaurantDao.saveAndFlush(restaurant);
  }
}
