package com.multai.vip.dao;

import com.multai.vip.bean.Address;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IAddressDAO extends JpaRepository<Address, Integer> {
  Address findByAddressId(int paramInt);
  
  List<Address> findAllByUserId(int paramInt);
  
  boolean deleteById(int paramInt);
}
