package com.multai.vip.service;

import com.multai.vip.bean.Address;
import com.multai.vip.dao.IAddressDAO;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class AddressService implements IAddressService {
  @Autowired
  IAddressDAO addressDao;
  
  public Address getAddressById(int addressId) {
    return this.addressDao.findByAddressId(addressId);
  }
  
  public int saveAddress(Address address) {
    this.addressDao.save(address);
    int addressId = ((Address)this.addressDao.findAll().get(this.addressDao.findAll().size() - 1)).getAddressId();
    System.out.println(addressId);
    return addressId;
  }
  
  public List<Address> getAllAddress(int userId) {
    return this.addressDao.findAllByUserId(userId);
  }
  
  public void deleteAddressByAddressId(int addressId) {
    this.addressDao.deleteById(addressId);
  }
  
  public void updateAddress(Address address) {
    this.addressDao.saveAndFlush(address);
  }
}
