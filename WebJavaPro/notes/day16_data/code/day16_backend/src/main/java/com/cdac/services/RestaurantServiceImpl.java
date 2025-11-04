package com.cdac.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cdac.customExceptions.ResourceAlreadyExistException;
import com.cdac.customExceptions.ResourceNotFound;
import com.cdac.dao.RestaurantDao;
import com.cdac.entities.Restaurant;

@Service
@org.springframework.transaction.annotation.Transactional
public class RestaurantServiceImpl implements RestaurantService {

	@Autowired
	private RestaurantDao restaurantDao;

	@Override
	public List<Restaurant> getList() {

		return restaurantDao.findByStatus(true);
	}

	@Override
	public String addRestaurant(Restaurant newRestaurant) {
		//check if restaurant already available exist
		String mesg = "Restaurant Already exists! choose some other name";
		if(restaurantDao.existsByName(newRestaurant.getName())) {
			 throw new ResourceAlreadyExistException("Error");
			
		}
		else {
			//set stataus to true
			
			newRestaurant.setStatus(true);
			//save the details
			Restaurant persistantRestaurant = restaurantDao.save(newRestaurant);
		
			return "added new Reataurent with id = "+persistantRestaurant.getId();
		}
		
		
		
	}

	@Override
	public String deleteRestaurant(Long restaurantId) {
		Restaurant restaurantNew = restaurantDao.findById(restaurantId).orElseThrow(()->new ResourceNotFound("Restaurant not found with given id"));
		restaurantNew.setStatus(false);
		return "soft deleted";
		
	}

}
