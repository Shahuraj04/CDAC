package com.mms.services;

import static com.mms.validation.Validations.validateAll;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

import com.mms.core.Genre;
import com.mms.core.Movie;
import com.mms.movieexception.MovieException;;

public class MovieServiecsImpl implements MovieServices {

	Scanner sc = new Scanner(System.in);
	Map<Integer, Movie> movieMap = new HashMap<>();
	private static int counter = 0;

	public MovieServiecsImpl() {
		movieMap.put(++counter, new Movie("Inception", Genre.SCI_FI, LocalDate.of(2010, 7, 16), 9, true, 250.0));
		movieMap.put(++counter, new Movie("The Dark Knight", Genre.ACTION, LocalDate.of(2008, 7, 18), 10, true, 300.0));
		movieMap.put(++counter, new Movie("La La Land", Genre.ROMANCE, LocalDate.of(2016, 12, 9), 8, false, 200.0));
		movieMap.put(++counter,
				new Movie("Avengers: Endgame", Genre.ACTION, LocalDate.of(2019, 4, 26), 9, true, 350.0));
		movieMap.put(++counter, new Movie("The Matrix", Genre.SCI_FI, LocalDate.of(1999, 3, 31), 9, false, 220.0));
	}

	@Override
	public String addMovie() throws MovieException {
		System.out.println("Enter Movie Title: ");
		String mname = sc.next();
		System.out.println("Enter Movie Genre: ");
		String mgenre = sc.next();
		System.out.println("Enter Movie Release date(yyyy-mm-dd): ");
		String mrDate = sc.next();
		LocalDate movieDate = LocalDate.parse(mrDate);
		System.out.println("Enter Movie Rating: ");
		int mrating = sc.nextInt();
		System.out.println("Enter Movie Availabilty: ");
		boolean mAvail = sc.nextBoolean();
		System.out.println("Enter Ticket Price: ");
		double mprice = sc.nextDouble();
		Movie movie = validateAll(mname, mgenre, mrating, movieDate, mAvail, mprice);
		movieMap.put(movie.getMovieId(), movie);

		return "new Movie Added!!";
	}

	@Override
	public void showAll() {
		for (Movie m : movieMap.values()) {
			System.out.println(m);
		}
	}

	@Override
	public void sortById() {
		TreeMap<Integer, Movie> movieTree = new TreeMap<>(movieMap);
		for (Movie m : movieTree.values()) {
			System.out.println(m);
		}

	}

	@Override
	public void highestRatedMovie() throws MovieException {
		Movie m = movieMap.values().stream().max((m1, m2) -> Integer.compare(m1.getRating(), m2.getRating()))
				.orElseThrow(() -> new MovieException("No movies found"));
		System.out.println("Most rated movie:" + m);
	}

	@Override
	public String removeMovie() {
		boolean removed = movieMap.values().removeIf(m -> !m.isAvailable());
		return removed ? "Unavailable movies removed successfully!" : "No movie to remove";
	}

	@Override
	public String updatePrice() {
		System.out.println("Enter genre: ");
		String updateGenre = sc.next();
		System.out.println("Enter new Price: ");
		double newPrice = sc.nextDouble();
		Genre newGenre = Genre.valueOf(updateGenre);
		for (Movie m : movieMap.values()) {
			if (m.getGenre().equals(newGenre)) {
				m.setTicketPrice(newPrice);
			}
		}
		return "Price updated!!";
	}

	@Override
	public void displayByReleaseDate() {
		System.out.println("Enter Year: ");
		int date = sc.nextInt();
		LocalDate newDate = LocalDate.of(date, 01, 01);
		for (Movie m : movieMap.values()) {
			if (m.getReleaseDate().isAfter(newDate)) {
				System.out.println(m);
			}
		}

	}

	@Override
	public String sortByPrice() {
		movieMap.values().stream().sorted((m1,m2)->Double.compare(m1.getTicketPrice(), m2.getTicketPrice())).forEach((m) -> System.out.println(m));
		return null;
	}

}
