package com.libraryms.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.libraryms.DTO.BookDTO;
import com.libraryms.service.BookService;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/book")
@AllArgsConstructor
public class BookController {
	private final BookService bookService;
	

	@PutMapping("/add")
	public ResponseEntity<?> addBook(@Valid @RequestBody  BookDTO bookDTO){
		
		return ResponseEntity.status(HttpStatus.CREATED).body(bookService.addBook(bookDTO));
	}
	
	@PatchMapping("/update/{bookId}")
	public ResponseEntity<?> upadateInfo(@PathVariable Long bookId ){
		
		return ResponseEntity.status(HttpStatus.ACCEPTED).body(bookService.updateDetails(bookId));
	}
	
	
}
