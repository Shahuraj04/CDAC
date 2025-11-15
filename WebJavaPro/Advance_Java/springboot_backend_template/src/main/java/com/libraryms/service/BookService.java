package com.libraryms.service;

import com.libraryms.DTO.ApiResponse;
import com.libraryms.DTO.BookDTO;

public interface BookService {

	ApiResponse addBook(BookDTO bookDTO);

	ApiResponse updateDetails(Long bookId);

}
