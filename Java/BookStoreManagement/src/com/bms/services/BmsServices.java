package com.bms.services;

import com.bms.core.Book;
import com.bms.customexceptions.CustomException;

public interface BmsServices {
	
	String addBook() throws CustomException;
	void displayAll();
	void sortByID();
	String getExpensive();
	void removeBook();
	String setNewPrice();
	void sortByPrice();

}
