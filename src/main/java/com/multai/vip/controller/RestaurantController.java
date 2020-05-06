package com.multai.vip.controller;
import com.multai.vip.bean.Restaurant;
import com.multai.vip.service.IRestaurantService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping({"restaurant"})
public class RestaurantController {
  @Autowired
  IRestaurantService restaurantService;
  
  @GetMapping({"/get/restaurantId/{restaurantId}"})
  public Restaurant getRestaurantById(@PathVariable int restaurantId) {
    return this.restaurantService.getRestaurantById(restaurantId);
  }
  
  @GetMapping({"/get/userId/{userId}"})
  public Restaurant getRestaurantByUserId(@PathVariable int userId) {
    return this.restaurantService.getRestaurantByUserId(userId);
  }
  
  @GetMapping({"/add/{userId}/{name}/{placeName}/{offerPercentage}/{offerAmount}/{offerRating}"})
  public long addRestaurants(@PathVariable int userId, @PathVariable String name, @PathVariable String placeName, @PathVariable float offerPercentage, @PathVariable float offerAmount, @PathVariable int offerRating) {
    Restaurant restaurant = new Restaurant();
    restaurant.setName(name);
    restaurant.setOfferAmount(offerAmount);
    restaurant.setOfferPercentage(offerPercentage);
    restaurant.setOfferRating(offerRating);
    restaurant.setUserId(userId);
    restaurant.setPlaceName(placeName);
    return this.restaurantService.saveRestaurant(restaurant);
  }
  
  @GetMapping({"/get/all"})
  public List<Restaurant> getAllRestaurant() {
    return this.restaurantService.getAllRestaurant();
  }
  
  @GetMapping({"/delete/{restaurantId}"})
  public void deleteRestaurantByRestaurantId(@PathVariable long restaurantId) {
    restaurantService.deleteRestaurantByRestaurantId(restaurantId);
  }
  
  @GetMapping({"/update/{restaurantId}/{userId}/{name}/{placeName}/{offerPercentage}/{offerAmount}/{offerRating}"})
  public String update(@PathVariable long restaurantId, @PathVariable int userId, @PathVariable String name, @PathVariable String placeName, @PathVariable float offerPercentage, @PathVariable float offerAmount, @PathVariable int offerRating) {
    Restaurant restaurant = new Restaurant();
    restaurant.setRestaurantId(restaurantId);
    restaurant.setName(name);
    restaurant.setOfferAmount(offerAmount);
    restaurant.setOfferPercentage(offerPercentage);
    restaurant.setOfferRating(offerRating);
    restaurant.setUserId(userId);
    restaurant.setPlaceName(placeName);
    this.restaurantService.updateRestaurant(restaurant);
    return "Entry updated Successfully";
  }
}
