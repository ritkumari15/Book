package com.Book.service;

import com.Book.dto.BookDto;

public interface BookService {

	
	public BookDto addBook(BookDto bookDto);
	
	public BookDto getBook(Long id);
	
	public BookDto updateBook(BookDto bookDto);
	
	public void deleteBook(Long id);
}
