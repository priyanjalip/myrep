package com.multai.vip.dao;

import com.multai.vip.bean.ImageModel;

import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ImageRepository extends JpaRepository<ImageModel, Long> {
	Optional<ImageModel> findByItemId(int paramInt);

	List<ImageModel> findByRestaurantId(int restaurantId);
}
