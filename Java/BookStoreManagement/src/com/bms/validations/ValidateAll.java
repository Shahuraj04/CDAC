package com.bms.validations;

import com.bms.core.Book;
import com.bms.core.Genre;
import com.bms.customexceptions.CustomException;

public class ValidateAll {

	public static Book validateAll(Book b) throws CustomException {
		validateRating(b.getRating());
		validateTitle(b.getTitle());
		
		validateGenre(b.getStringType());
		return b;

	}

	public static void validateRating(int rating) throws CustomException {
		if (rating > 5 || rating < 1) {
			throw new CustomException("Enter Valid Rating!!");
		}

	};

	public static void validateTitle(String title) throws CustomException {
		if (title.length() > 50 || title.length() < 3) {
			throw new CustomException("Enter neat Title!!");
		}

	}

	public static Genre validateGenre(String input) {
		try {
			return Genre.valueOf(input.toUpperCase());
		} catch (IllegalArgumentException e) {
			throw new IllegalArgumentException("Invalid Genre: must be FICTION, NONFICTION, SCIENCE, or HISTORY");
		}
	}

}
