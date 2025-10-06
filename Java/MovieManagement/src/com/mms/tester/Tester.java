package com.mms.tester;

import java.util.Scanner;

import com.mms.services.MovieServices;
import com.mms.services.MovieServiecsImpl;

public class Tester {
	public static void main(String[] args) {
			Scanner sc = new Scanner(System.in);
			MovieServices services = new MovieServiecsImpl();
			boolean exit=false;
			while(!exit) {
				System.out.println(
					    "1. Add Movie\n" +
					    "2. Show All Movies\n" +
					    "3. Show Movies Sorted by ID\n" +
					    "4. Find Most Expensive Movie\n" +
					    "5. Remove Unavailable Movies\n" +
					    "6. Update Ticket Price by Title\n" +
					    "7. Sort Movies by Price\n" +
					    "8. Exit\n" +
					    "Enter your choice: "
					);

				System.err.println("Enter Choice: ");
				int choice= sc.nextInt();
				try {
					switch (choice) {
					case 1: {
						services.addMovie();
						break;
					}
					case 2:{
						services.showAll();
						break;
					}
					case 3:{
						services.sortById();
						break;
					}
					case 4:{
						services.highestRatedMovie();
						break;
					}
					case 5:{
						services.removeMovie();
						
						break;
					}
					case 6:{
						services.updatePrice();
						break;
					}
					case 7:{
						services.displayByReleaseDate();
						break;
					}
					case 8:{
						services.sortByPrice();
						break;
					}
					case 9:{
						exit=true;
						break;
					}
					default:
						throw new IllegalArgumentException("Unexpected value: " + choice);
					}
					
					
				}catch (Exception e) {
					System.out.println(e.getMessage());
				}
				
				
			}
			
		
		
	}

}
