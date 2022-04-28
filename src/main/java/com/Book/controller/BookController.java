package com.Book.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Book.dto.BookDto;
import com.Book.dto.StoreDto;
import com.Book.service.BookService;

@RestController
@RequestMapping("/book")
public class BookController {

	@Autowired
	private BookService service;
	
	
	@PostMapping("/add")
	public ResponseEntity<?> createBook(@RequestBody BookDto bookDto){
		BookDto bookDto2 = service.addBook(bookDto);
		if (bookDto2==null) {
			return new ResponseEntity<String>("Internal server error", HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<BookDto>(bookDto2, HttpStatus.CREATED);
	}
	
	@PostMapping("/update")
	public ResponseEntity<?> updateBook(@RequestBody BookDto bookDto){
		BookDto bookDto2 = service.updateBook(bookDto);
		if (bookDto2==null) {
			return new ResponseEntity<String>("Internal server error", HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<BookDto>(bookDto2, HttpStatus.OK);
	}
	@GetMapping("/get")
	public ResponseEntity<?> getBook(@PathVariable("id") Long id){
		BookDto bookDto2 = service.getBook(id);
		if (bookDto2==null) {
			return new ResponseEntity<String>("Internal server error", HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<BookDto>(bookDto2, HttpStatus.OK);
	}
	
	@DeleteMapping("/get")
	public ResponseEntity<?> deleteBook(@PathVariable("id") Long id){
		service.deleteBook(id);
		
		return new ResponseEntity<BookDto>( HttpStatus.OK);
	}
	
	
}
