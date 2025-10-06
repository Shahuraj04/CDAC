package com.bms.services;

import static com.bms.validations.ValidateAll.validateAll;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

import com.bms.core.Book;
import com.bms.core.Genre;
import com.bms.customexceptions.CustomException;;

public class BmsServicesImpl implements BmsServices {

	Scanner sc = new Scanner(System.in);
	private Map<Integer, Book> map = new HashMap<>();
	
	public BmsServicesImpl() {
	    List<Book> bookList = new ArrayList<>();

	    bookList.add(new Book("Java Basics", "John Doe", Genre.SCIENCE, 199.99, 5, true));
	    bookList.add(new Book("Spring Boot Guide", "Jane Smith", Genre.FICTION, 299.50, 4, true));
	    bookList.add(new Book("Hibernate Tips", "Bob Brown", Genre.HISTORY, 399.00, 3, false));
	    bookList.add(new Book("Data Structures", "Alice White", Genre.NONFICTION, 249.75, 4, true));

	    map = new HashMap<>();
	    for (Book b : bookList) {
	        map.put(b.getBookId(), b);
	    }
	}

	@Override
	public String addBook() throws CustomException {
		System.out.println("Enter Book Title: ");
		String bname = sc.next();
		System.out.println("Enter Book Author:");
		String bauthor = sc.next();
		System.out.println("Enter Book Genre(FICTION,NONFICTION,SCIENCE,HISTORY): ");
		String btype = sc.next();
		Genre g = Genre.valueOf(btype);
		System.out.println("Enter Book Price: ");
		double bprice = sc.nextDouble();
		System.out.println("Enter Book Rating: ");
		int brate = sc.nextInt();
		System.out.println("Book AVAILABILITY(TRUE/FALSE): ");
		boolean checkAvailable = sc.nextBoolean();
		Book b = new Book(btype, bauthor, g, bprice, brate, checkAvailable);
		validateAll(b);
		map.put(b.getBookId(), b);
		return "Book Added1!!!";

	}

	@Override
	public void displayAll() {
		for (Book b : map.values()) {
			System.out.println(b);
		}

	}

	@Override
	public void sortByID() {
		TreeMap<Integer, Book> tb = new TreeMap<>(map);
		for (Book tBook : tb.values()) {
			System.out.println(tBook);
		}

	}
	@Override
	public String getExpensive() {
	    if (map.isEmpty()) {
	        return "No books in the store!";
	    }

	    Book exBook = null;
	    for (Book newBook : map.values()) {
	        if (exBook == null || newBook.getPrice() > exBook.getPrice()) {
	            exBook = newBook;
	        }
	    }

	    return "Most Expensive Book: " + exBook.getTitle() + " ($" + exBook.getPrice() + ")";
	}

	@Override
	public void removeBook() {
	    map.values().removeIf(book -> !book.isAvailableInstore());
	    System.out.println("Unavailable books removed successfully.");
	}
	@Override
	public String setNewPrice() {
		System.out.println("Enter Author name: ");
		String auth = sc.nextLine();
		System.out.println("Enter new Price: ");
		double newprice= sc.nextDouble();
		for(Book b : map.values()) {
			if(b.getAuthor().equals(auth)) {
				b.setPrice(newprice);
			}
		}
		
		return "Price Updated";
	}
	@Override
	public void sortByPrice() {
	    map.values().stream()
	       .sorted((b1, b2) -> Double.compare(b2.getPrice(), b1.getPrice())) 
	       .forEach(book -> System.out.println(
	           "ID: " + book.getBookId() +
	           ", Title: " + book.getTitle() +
	           ", Author: " + book.getAuthor() +
	           ", Genre: " + book.getGenre() +
	           ", Price: $" + book.getPrice() +
	           ", Rating: " + book.getRating() +
	           ", Available: " + book.isAvailableInstore()
	       ));
	}
}


