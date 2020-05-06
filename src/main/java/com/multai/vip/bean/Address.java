package com.multai.vip.bean;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Address {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private int addressId;
  
  private int userId;
  
  private String user;
  
  private String addressFirstField;
  
  private String addressSecoundField;
  
  private String Landmark;
  
  private String city;
  
  private String state;
  
  private int zip;
  
  private Long mobile;
  
  public int getAddressId() {
    return this.addressId;
  }
  
  public void setAddressId(int addressId) {
    this.addressId = addressId;
  }
  
  public int getUserId() {
    return this.userId;
  }
  
  public void setUserId(int userId) {
    this.userId = userId;
  }
  
  public String getUser() {
    return this.user;
  }
  
  public void setUser(String user) {
    this.user = user;
  }
  
  public String getAddressFirstField() {
    return this.addressFirstField;
  }
  
  public void setAddressFirstField(String addressFirstField) {
    this.addressFirstField = addressFirstField;
  }
  
  public String getAddressSecoundField() {
    return this.addressSecoundField;
  }
  
  public void setAddressSecoundField(String addressSecoundField) {
    this.addressSecoundField = addressSecoundField;
  }
  
  public String getLandmark() {
    return this.Landmark;
  }
  
  public void setLandmark(String landmark) {
    this.Landmark = landmark;
  }
  
  public String getCity() {
    return this.city;
  }
  
  public void setCity(String city) {
    this.city = city;
  }
  
  public String getState() {
    return this.state;
  }
  
  public void setState(String state) {
    this.state = state;
  }
  
  public int getZip() {
    return this.zip;
  }
  
  public void setZip(int zip) {
    this.zip = zip;
  }
  
  public Long getMobile() {
    return this.mobile;
  }
  
  public void setMobile(Long mobile) {
    this.mobile = mobile;
  }
  
  public String toString() {
    return "Address [addressId=" + this.addressId + ", userId=" + this.userId + ", user=" + this.user + ", addressFirstField=" + this.addressFirstField + ", addressSecoundField=" + this.addressSecoundField + ", Landmark=" + this.Landmark + ", city=" + this.city + ", state=" + this.state + ", zip=" + this.zip + ", mobile=" + this.mobile + "]";
  }
}
