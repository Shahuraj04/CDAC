package com.bms.tester;

import java.util.InputMismatchException;
import java.util.Scanner;

import com.bms.customexceptions.CustomException;
import com.bms.services.BmsServicesImpl;

public class Tester {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);  
        BmsServicesImpl services = new BmsServicesImpl();
        boolean exit = false;

        while (!exit) {
            System.out.println("\n--- Book Management Menu ---");
            System.out.println("1. Add new Book");
            System.out.println("2. Display all Books");
            System.out.println("3. Display all Books sorted by ID");
            System.out.println("4. Find most expensive Book");
            System.out.println("5. Remove unavailable Books");
            System.out.println("6. Update price by author");
            System.out.println("7. Sort all Books by price");
            System.out.println("8. Exit");
            System.out.print("Enter your choice: ");

            try {
                int choice = sc.nextInt();
                sc.nextLine(); 

                switch (choice) {
                    case 1:
                        services.addBook();
                        break;
                    case 2:
                        services.displayAll();
                        break;
                    case 3:
                        services.sortByID();
                        break;
                    case 4:
                        System.out.println(services.getExpensive());
                        break;
                    case 5:
                        services.removeBook();
                        break;
                    case 6:
                        services.setNewPrice();
                        break;
                    case 7:
                        services.sortByPrice();
                        break;
                    case 8:
                        exit = true;
                        System.out.println("Exiting application...");
                        break;
                    default:
                        System.out.println("Invalid choice! Please enter 1-8.");
                        break;
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid input! Please enter a number.");
                sc.nextLine();
            } catch (CustomException c) {
                System.err.println(c.getMessage());
            }
        }

        sc.close();
    }
}
