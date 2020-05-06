package com.multai.vip.bean;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Person {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private int userId;
  
  private String firstName;
  
  private String lastName;
  
  private Long mobile;
  
  private String password;
  
  private String email;
  
  private String adminType="User";
  
  public String getAdminType() {
    return this.adminType;
  }
  
  public void setAdminType(String adminType) {
    this.adminType = adminType;
  }
  
  public int getUserId() {
    return this.userId;
  }
  
  public void setUserId(int userId) {
    this.userId = userId;
  }
  
  public String getFirstName() {
    return this.firstName;
  }
  
  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }
  
  public String getLastName() {
    return this.lastName;
  }
  
  public void setLastName(String lastName) {
    this.lastName = lastName;
  }
  
  public Long getMobile() {
    return this.mobile;
  }
  
  public void setMobile(Long mobile) {
    this.mobile = mobile;
  }
  
  public String getPassword() {
    return this.password;
  }
  
  public void setPassword(String password) {
    this.password = password;
  }
  
  public String getEmail() {
    return this.email;
  }
  
  public void setEmail(String email) {
    this.email = email;
  }
  
  public String toString() {
    return "Person [userId=" + this.userId + ", firstName=" + this.firstName + ", lastName=" + this.lastName + ", mobile=" + this.mobile + ", password=" + this.password + ", email=" + this.email + ", adminType=" + this.adminType + "]";
  }
}
