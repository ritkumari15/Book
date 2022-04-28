package com.Book.service.impl;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Book.dto.BookDto;
import com.Book.dto.StoreDto;
import com.Book.entity.Book;
import com.Book.entity.Store;
import com.Book.mapper.BookMapper;
import com.Book.repo.BookRepository;
import com.Book.repo.StoreRepository;
import com.Book.service.BookService;
import com.Book.service.StoreService;

@Service
public class BookServiceImpl implements BookService {

	@Autowired
	private BookRepository repository;
	
	@Autowired
	private StoreRepository storeRepository;

	
	@Override
	public BookDto addBook(BookDto bookDto) {
		
		
		Book book1 = repository.getByName(bookDto.getName());
		
		if(book1!=null) {
			
			updateBookCountInc(book1);
			
			return BookMapper.entityToDto(book1);
		}
		Book book = new Book();
		book.setName(bookDto.getName());
		if(bookDto.getStores()!=null) {
		for(Long id : bookDto.getStores()) {
			Store store = getStore(id);
			book.getStore().add(store);
		}
		}
		book.setCount(1l);
		
		return BookMapper.entityToDto( repository.save(book));
		
	}

	@Override
	public BookDto getBook(Long id) {
		// TODO Auto-generated method stub
		
		Book book = repository.getById(id);
		updateBookCountDesc(book);
		return BookMapper.entityToDto(book);
	}
	
	private Store getStore(Long id) {
		return storeRepository.getById(id);
	}

	@Override
	public BookDto updateBook(BookDto bookDto) {
		// TODO Auto-generated method stub
		
		Book oldBook = repository.getById(bookDto.getId());
		oldBook.setName(bookDto.getName());
		if(bookDto.getStores()!=null) {
			for(Long id : bookDto.getStores()) {
				Store store = getStore(id);
				oldBook.getStore().add(store);
			}
			}
		return BookMapper.entityToDto(repository.save(oldBook));
	}

	private BookDto updateBookCountDesc(Book book) {
		// TODO Auto-generated method stub
		
		Book oldBook = repository.getById(book.getId());
		oldBook.setCount(book.getCount()-1);
		if(book.getCount()-1==0) {
			deleteBook(book.getId());
			return BookMapper.entityToDto(oldBook);
		}
		return BookMapper.entityToDto(repository.save(oldBook));
	}
	private BookDto updateBookCountInc(Book book) {
		// TODO Auto-generated method stub
		
		Book oldBook = repository.getById(book.getId());
		oldBook.setCount(book.getCount()+1);
		
		return BookMapper.entityToDto(repository.save(oldBook));
	}
	@Override
	public void deleteBook(Long id) {
		repository.deleteById(id);
		
	}

}
