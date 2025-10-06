package com.mms.validation;

import java.time.LocalDate;

import com.mms.core.Genre;
import com.mms.core.Movie;
import com.mms.movieexception.MovieException;

public class Validations {

	public static Movie validateAll(String name, String genre, int rating, LocalDate date,boolean avail,double price) throws MovieException {
		validateTitle(name);
		validateRating(rating);
		validateDate(date);
		Genre movieGen = validateGenre(genre);

		return new Movie(name, movieGen, date, rating, avail, price);

	}

	private static Genre validateGenre(String genre) throws MovieException {
		try {
			return Genre.valueOf(genre.trim().toUpperCase());
		} catch (IllegalArgumentException e) {
			throw new MovieException("Enter valid genre!!");
		}

	}

	public static void validateTitle(String mname) throws MovieException {
		if (mname.length() < 2 || mname.length() > 50) {
			throw new MovieException("Enter Valid Title!!");
		}

	}

	public static void validateRating(int rate) throws MovieException {
		if (rate < 0 || rate > 10) {
			throw new MovieException("Enter rating 0-10");
		}
	}

	public static void validateDate(LocalDate date) throws MovieException {
		if (date.isAfter(LocalDate.now())) {
			throw new MovieException("Dont add future date");
		}
	}
}
