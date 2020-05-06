package com.multai.vip.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "restaurant")
public class Restaurant {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private long restaurantId;
  
  private String name;
  
  private String placeName;
  
  private float offerPercentage;
  
  private float offerAmount;
  
  private int offerRating;
  
  @Column(unique = true)
  private int userId;
  
  public int getUserId() {
    return this.userId;
  }
  
  public void setUserId(int userId) {
    this.userId = userId;
  }
  
  public long getRestaurantId() {
    return this.restaurantId;
  }
  
  public void setRestaurantId(long restaurantId) {
    this.restaurantId = restaurantId;
  }
  
  public String getName() {
    return this.name;
  }
  
  public void setName(String name) {
    this.name = name;
  }
  
  public String getPlaceName() {
    return this.placeName;
  }
  
  public void setPlaceName(String placeName) {
    this.placeName = placeName;
  }
  
  public float getOfferPercentage() {
    return this.offerPercentage;
  }
  
  public void setOfferPercentage(float offerPercentage) {
    this.offerPercentage = offerPercentage;
  }
  
  public float getOfferAmount() {
    return this.offerAmount;
  }
  
  public void setOfferAmount(float offerAmount) {
    this.offerAmount = offerAmount;
  }
  
  public int getOfferRating() {
    return this.offerRating;
  }
  
  public void setOfferRating(int offerRating) {
    this.offerRating = offerRating;
  }
  
  public String toString() {
    return "Restaurant [restaurantId=" + this.restaurantId + ", name=" + this.name + ", placeName=" + this.placeName + ", offerPercentage=" + this.offerPercentage + ", offerAmount=" + this.offerAmount + ", offerRating=" + this.offerRating + ", userId=" + this.userId + "]";
  }
}
