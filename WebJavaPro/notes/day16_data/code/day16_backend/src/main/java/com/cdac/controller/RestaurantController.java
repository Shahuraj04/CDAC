package com.cdac.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cdac.dao.RestaurantDao;
import com.cdac.entities.Restaurant;
import com.cdac.services.RestaurantService;

@RestController
@RequestMapping("/restaurants")
public class RestaurantController {

	private final RestaurantDao restaurantDao;

	@Autowired
	private RestaurantService restaurantService;

	RestaurantController(RestaurantDao restaurantDao) {
		this.restaurantDao = restaurantDao;
	}

	@GetMapping()
	public ResponseEntity<?> getAvailableRestaurants() {
		List<Restaurant> list = restaurantService.getList();
		if (list.isEmpty()) {
			return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
			// SC 204
		}
		return ResponseEntity.ok(list);
		// sc:200
	}

	// add new Restaurant
	// url host:port/restaurants
	// Method POST
	// resp String SUCCESS | FAILURE
	@PostMapping
	public ResponseEntity<?> addNewRestaurant(@RequestBody ) {

	return null;
	}
}
