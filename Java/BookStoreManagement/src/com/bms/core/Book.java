package com.bms.core;

public class Book {

	private int bookId;
	private String title;
	private String author;
	private Genre genre;
	private double price;
	private int rating;
	boolean availableInstore;
	static int counter;
	public Book(String title, String author, Genre genre, double price, int rating,
			boolean availableInstore) {
		
		this.bookId = ++counter;
		this.title = title;
		this.author = author;
		this.genre = genre;
		this.price = price;
		this.rating = rating;
		this.availableInstore = availableInstore;
	}
	public int getBookId() {
		return bookId;
	}
	public void setBookId(int bookId) {
		this.bookId = bookId;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public Genre getGenre() {
		return genre;
	}
	public void setGenre(Genre genre) {
		this.genre = genre;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public int getRating() {
		return rating;
	}
	public void setRating(int rating) {
		this.rating = rating;
	}
	public boolean isAvailableInstore() {
		return availableInstore;
	}
	public void setAvailableInstore(boolean availableInstore) {
		this.availableInstore = availableInstore;
	}
	public static int getCounter() {
		return counter;
	}
	public static void setCounter(int counter) {
		Book.counter = counter;
	}
	public String getStringType() {
	    return genre.name();   
	}

	@Override
	public String toString() {
		return "Book [bookId=" + bookId + ", title=" + title + ", author=" + author + ", genre=" + genre + ", price="
				+ price + ", rating=" + rating + ", availableInstore=" + availableInstore + "]";
	}
	
	
	
	
}
