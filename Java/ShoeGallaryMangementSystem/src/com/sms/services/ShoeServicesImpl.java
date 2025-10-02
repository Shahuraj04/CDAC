package com.sms.services;

import static com.sms.customException.Validations.validateAll;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

import com.sms.core.Shoe;
import com.sms.core.ShoeType;
import com.sms.customException.CustomException;

public class ShoeServicesImpl implements ShoeServices {

	private List<Shoe> shoeList = new ArrayList<>();
	Scanner sc = new Scanner(System.in);

	private String name;
	private String Brand;
	private int rating;
	private double price;
	private boolean availableInGallery;
	private String Shoe_type;

	public ShoeServicesImpl() {
		try {
			addShoe("AirMax", "Nike", 8, 5999.99, true, ShoeType.SPORTS);
			addShoe("Classic", "Adidas", 7, 4999.50, false, ShoeType.CASUAL);
			addShoe("Loafer", "Bata", 6, 1999.00, true, ShoeType.FORMAL);
		} catch (CustomException e) {
			System.out.println("Failed to add default shoes: " + e.getMessage());
		}
	}

	@Override
	public void getDetails() throws CustomException {
		System.out.println("Enter Name");
		name = sc.next();

		System.out.println("Enter Brand");
		Brand = sc.next();

		System.out.println("Enter Rating (1-10)");
		rating = sc.nextInt();

		System.out.println("Enter Price");
		price = sc.nextDouble();

		System.out.println("Availability (true/false)");
		availableInGallery = sc.nextBoolean();

		System.out.println("Enter Type (CASUAL / SPORTS / FORMAL)");
		Shoe_type = sc.next().toUpperCase(); 

		addShoe(name, Brand, rating, price, availableInGallery, ShoeType.valueOf(Shoe_type));
	}

	@Override
	public void addShoe(String name, String brand, int rating, double price, boolean availableInGallery, ShoeType type)
			throws CustomException {
		Shoe s = validateAll(name, brand, rating, price, availableInGallery, type);
		shoeList.add(s); 
	}

	@Override
	public void showAll() {
		for (Shoe s : shoeList) {
			System.out.println(s);
		}
	}

	@Override
	public void expensiveShoe() {
	    if (shoeList.isEmpty()) {
	        System.out.println("No shoes available.");
	        return;
	    }

	    Shoe mostExpensive = shoeList.get(0); 

	    for (Shoe s : shoeList) {
	        if (s.getPrice() > mostExpensive.getPrice()) {
	            mostExpensive = s; 
	        }
	    }

	    System.out.println("Most expensive shoe:");
	    System.out.println(mostExpensive);
	}


	@Override
	public String searchById() {
		System.out.print("Enter Shoe ID:");
		int searchId = sc.nextInt();
		for(Shoe s : shoeList) {
			if(s.getShoe_id()==searchId) {
				return "Shoe found:"+s;
			}
			
		}
		return "NO Shoe found with given id!!!"; 
		
		
	}

	@Override
	public String removeShoe() {
		boolean removed = false;
		for(Shoe s : shoeList) {
			if(s.isAvailableInGallery()==false) {
				shoeList.remove(s);
				removed=true;
				
			}
		}
		if(removed==true) {
			return "Shoe Removed";
		}
		else {
			return "All Shoes are available";
		}
	}

	@Override
	public String updatePrice() {
		System.out.println("Enter Shoe ID to update price");
		int updateId = sc.nextInt();
		System.out.println("Enter new price:");
		double updatedprice = sc.nextDouble();
		
		for(Shoe s : shoeList) {
			
			if(s.getShoe_id()==updateId) {
				s.setPrice(updatedprice);
			}
			
		}
		return "Updated";
	}

	@Override
	public void sortShoe() {
	    if (shoeList.isEmpty()) {
	        System.out.println("No shoes to sort.");
	        return;
	    }

	    
	    Collections.sort(shoeList);

	    System.out.println("Shoes sorted by price (descending):");
	    showAll();  
	}


}
