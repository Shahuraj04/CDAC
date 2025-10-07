package com.mms.services;

import java.util.Map;

import com.mms.movieexception.MovieException;

public interface MovieServices {
	
	public String addMovie() throws MovieException;
	public void showAll();
	public void sortById();
	public void highestRatedMovie() throws MovieException;
	public String removeMovie();
	public String updatePrice();
	public void displayByReleaseDate();
	public String sortByPrice();
	
	

}
