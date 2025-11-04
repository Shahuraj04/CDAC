package com.cdac.controller;

import java.util.List;
import com.cdac.services.RestaurantServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cdac.customExceptions.ResourceAlreadyExistException;
import com.cdac.customExceptions.ResourceNotFound;
import com.cdac.dao.RestaurantDao;
import com.cdac.entities.Restaurant;
import com.cdac.services.RestaurantService;

@RestController
@RequestMapping("/restaurants")
public class RestaurantController {

    private final RestaurantServiceImpl restaurantServiceImpl;

	private final TestController testController;

	private final RestaurantDao restaurantDao;

	@Autowired
	private RestaurantService restaurantService;

	RestaurantController(RestaurantDao restaurantDao, TestController testController, RestaurantServiceImpl restaurantServiceImpl) {
		this.restaurantDao = restaurantDao;
		this.testController = testController;
		this.restaurantServiceImpl = restaurantServiceImpl;
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
	// success sc201 + success mesg
	// sc 400 + err mesg
	@PostMapping
	public ResponseEntity<?> addNewRestaurant(@RequestBody Restaurant newRestaurant) {

		System.out.println("in add new restaurant" + newRestaurant);
		// invoke service layer method
		try {
			String restaurant = restaurantService.addRestaurant(newRestaurant);
			return ResponseEntity.status(HttpStatus.CREATED).body(restaurant);

		} catch (ResourceAlreadyExistException e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());

		}

	}

	// delete existing Restaurant
	// url host:port/restaurants/{restaurantId}
	// Method DELETE
	// resp String SUCCESS | FAILURE
	// success sc200 + success mesg
	// sc 404
	@DeleteMapping("/{restaurantId}")
	public ResponseEntity<?> deleteRestaurantDetails(@PathVariable Long restaurantId) {
		System.out.println("in delete restaurant"+ restaurantId);
		try {
			String deleteRestaurant = restaurantService.deleteRestaurant(restaurantId);
			return ResponseEntity.status(HttpStatus.OK).body(deleteRestaurant);
		} catch (ResourceNotFound e) {
			return ResponseEntity.notFound().build();
					}
		
	}

}
