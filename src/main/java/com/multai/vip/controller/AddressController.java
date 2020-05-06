package com.multai.vip.controller;

import com.multai.vip.bean.Address;
import com.multai.vip.service.AddressService;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping({"/address"})
public class AddressController {
  @Autowired
  AddressService addressService;
  
  @GetMapping({"/get/{addressId}"})
  public Address getAddressById(@PathVariable int addressId) {
    return this.addressService.getAddressById(addressId);
  }
  
  @GetMapping({"/add/{userId}/{user}/{addressFirstField}/{addressSecoundField}/{city}/{Landmark}/{state}/{zip}/{mobile}"})
  public int addAddress(@PathVariable int userId, @PathVariable String user, @PathVariable String addressFirstField, @PathVariable String addressSecoundField, @PathVariable String city, @PathVariable String Landmark, @PathVariable String state, @PathVariable int zip, @PathVariable Long mobile) {
    Address address = new Address();
    address.setUser(user);
    address.setUserId(userId);
    address.setAddressFirstField(addressFirstField);
    address.setAddressSecoundField(addressSecoundField);
    address.setLandmark(Landmark);
    address.setCity(city);
    address.setState(state);
    address.setZip(zip);
    address.setMobile(mobile);
    return this.addressService.saveAddress(address);
  }
  
  @GetMapping({"/get/all/{userId}"})
  public List<Address> getAllAddressById(@PathVariable int userId) {
    List<Address> list = new ArrayList<>();
    list = this.addressService.getAllAddress(userId);
    return list;
  }
  
  @GetMapping({"/delete/{addressId}"})
  public String deleteAddressById(@PathVariable int addressId) {
    try {
      this.addressService.deleteAddressByAddressId(addressId);
    } catch (Exception exception) {}
    return "Address deleted Successfully";
  }
  
  @GetMapping({"/update/{addressId}/{userId}/{user}/{addressFirstField}/{addressSecoundField}/{city}/{Landmark}/{state}/{zip}"})
  public String updateAddress(@PathVariable int addressId, @PathVariable int userId, @PathVariable String user, @PathVariable String addressFirstField, @PathVariable String addressSecoundField, @PathVariable String city, @PathVariable String Landmark, @PathVariable String state, @PathVariable int zip) {
    Address address = new Address();
    address.setAddressId(addressId);
    address.setUserId(userId);
    address.setUser(user);
    address.setAddressFirstField(addressFirstField);
    address.setAddressSecoundField(addressSecoundField);
    address.setLandmark(Landmark);
    address.setCity(city);
    address.setState(state);
    address.setZip(zip);
    this.addressService.updateAddress(address);
    return "Entry updated Successfully";
  }
}
