package com.mms.core;

import java.time.LocalDate;

public class Movie {
	private int movieId;
	private String title;
	private Genre genre;
	private LocalDate releaseDate;
	private int rating;
	private boolean isAvailable;
	private double ticketPrice;
	static int counter; 
	public Movie(
			String title, Genre genre, LocalDate releaseDate, int rating, boolean isAvailable,
			double ticketPrice) {
		
		this.movieId = ++counter;
		this.title = title;
		this.genre = genre;
		this.releaseDate = releaseDate;
		this.rating = rating;
		this.isAvailable = isAvailable;
		this.ticketPrice = ticketPrice;
	}
	@Override
	public String toString() {
		return "Movie [movieId=" + movieId + ", title=" + title + ", genre=" + genre + ", releaseDate=" + releaseDate
				+ ", rating=" + rating + ", isAvailable=" + isAvailable + ", ticketPrice=" + ticketPrice + "]";
	}
	public int getMovieId() {
		return movieId;
	}
	public void setMovieId(int movieId) {
		this.movieId = movieId;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public Genre getGenre() {
		return genre;
	}
	public void setGenre(Genre genre) {
		this.genre = genre;
	}
	public LocalDate getReleaseDate() {
		return releaseDate;
	}
	public void setReleaseDate(LocalDate releaseDate) {
		this.releaseDate = releaseDate;
	}
	public int getRating() {
		return rating;
	}
	public void setRating(int rating) {
		this.rating = rating;
	}
	public boolean isAvailable() {
		return isAvailable;
	}
	public void setAvailable(boolean isAvailable) {
		this.isAvailable = isAvailable;
	}
	public double getTicketPrice() {
		return ticketPrice;
	}
	public void setTicketPrice(double ticketPrice) {
		this.ticketPrice = ticketPrice;
	}

}
