package com.sms.customException;

import com.sms.core.Shoe;
import com.sms.core.ShoeType;

public class Validations {
	
	public static Shoe validateAll(String name,String brand,int rating,double price,boolean availableInGallery,ShoeType type) throws CustomException {
		
		validateRating(rating);
		validateLength(name);
		validateType(type);
		return new Shoe(name, brand, rating, price, availableInGallery, type);
	}

	private static void validateType(ShoeType type) throws CustomException {
		if(type!=ShoeType.CASUAL && type!=ShoeType.SPORTS && type!=ShoeType.FORMAL ) {
			throw new CustomException("Enter valid type");
		}
		
	}

	private static void validateLength(String name) throws CustomException {
	    if (name.length() < 3 || name.length() > 20) {
	        throw new CustomException("Name must be between 3 and 20 characters");
	    }
	}


	private static void validateRating(int rating) throws CustomException {
		if(rating>10 || rating<=0 ) {
			throw new CustomException("Rating Must be in 1-10");
		}
		
	};

	
	

}
