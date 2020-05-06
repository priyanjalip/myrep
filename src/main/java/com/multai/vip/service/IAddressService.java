package com.multai.vip.service;

import com.multai.vip.bean.Address;
import java.util.List;
import javax.transaction.Transactional;
import org.springframework.stereotype.Component;

@Component
@Transactional
public interface IAddressService {
  Address getAddressById(int paramInt);
  
  int saveAddress(Address paramAddress);
  
  List<Address> getAllAddress(int paramInt);
  
  void deleteAddressByAddressId(int paramInt);
}
