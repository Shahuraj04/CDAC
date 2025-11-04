package com.cdac.services;

import java.util.List;

import com.cdac.entities.Restaurant;

public interface RestaurantService {

	List<Restaurant> getList();

	String addRestaurant(Restaurant newRestaurant);
	
}
