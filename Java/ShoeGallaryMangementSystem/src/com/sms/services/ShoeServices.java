package com.sms.services;

import com.sms.core.ShoeType;
import com.sms.customException.CustomException;

public interface ShoeServices {
	
	void getDetails() throws CustomException;
 	void addShoe(String name,String brand,int rating,double price,boolean availableInGallery,ShoeType type) throws CustomException;
	void showAll();
	void expensiveShoe();
	String searchById();
	String removeShoe();
	String updatePrice();
	void sortShoe();
	
}
