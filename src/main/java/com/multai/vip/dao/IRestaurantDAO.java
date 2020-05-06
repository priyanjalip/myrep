package com.multai.vip.dao;

import com.multai.vip.bean.Restaurant;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Transactional
@Repository
public interface IRestaurantDAO extends JpaRepository<Restaurant, Long> {
	Restaurant findByRestaurantId(long paramLong);

	Restaurant findByUserId(int paramInt);
}
