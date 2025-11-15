package com.libraryms.service;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.libraryms.DTO.ApiResponse;
import com.libraryms.DTO.BookDTO;
import com.libraryms.entities.Book;
import com.libraryms.repository.BookRepository;

import lombok.AllArgsConstructor;

@Service
@Transactional
@AllArgsConstructor
public class BookServiceImpl implements BookService {

	private final BookRepository bookRepository;
	private final ModelMapper mapper;

	@Override
	public ApiResponse addBook(BookDTO bookDTO) {

	    // Check if title already exists
	    if (bookRepository.findByTitle(bookDTO.getTitle()).isPresent()) {
	        throw new RuntimeException("Book already exists with same title");
	    }

	    Book newBook = mapper.map(bookDTO, Book.class);
	    newBook.setAvailable(true); // optional: default availability

	    bookRepository.save(newBook);

	    return new ApiResponse("New Book Added", "CREATED");
	}


	@Override
	public ApiResponse updateDetails(Long bookId) {
		Book book = bookRepository.findById(bookId).orElseThrow(()->new RuntimeException("not found id"));
		book.setAvailable(!book.isAvailable());
		bookRepository.save(book);
		
		return new ApiResponse("availability changed to: " + book.isAvailable(), "UPDATED");
	}

}
