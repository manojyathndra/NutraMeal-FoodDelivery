package com.nutrameals.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nutrameals.model.Restaurant;

public interface RestaurantRepository  extends JpaRepository<Restaurant, Integer>{
	
	List<Restaurant> findAll();
	
	Restaurant findByRestaurantName(String restaurantName);
	
}
