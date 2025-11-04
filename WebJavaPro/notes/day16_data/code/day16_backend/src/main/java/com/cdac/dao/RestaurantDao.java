package com.cdac.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cdac.entities.Restaurant;

import java.lang.foreign.Linker.Option;
import java.util.List;
import java.util.Optional;


public interface RestaurantDao extends JpaRepository<Restaurant, Long>{
	
	List<Restaurant> findByStatus(boolean status);
	
	boolean existsByName(String restaurantName);
	
	
}
