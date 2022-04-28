package com.Book.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Book.dto.StoreDto;
import com.Book.entity.Book;
import com.Book.entity.Store;
import com.Book.mapper.StoreMapper;
import com.Book.repo.BookRepository;
import com.Book.repo.StoreRepository;
import com.Book.service.StoreService;

@Service
public class StoreServiceImpl implements StoreService{

	@Autowired 
	private StoreRepository repository;
	
	@Autowired
	private BookRepository bookRepository;
	
	@Override
	public StoreDto addStore(StoreDto storeDto) {
		// TODO Auto-generated method stub
		
		Store store = new Store();
		store.setName(storeDto.getName());
		
		if(storeDto.getBooks()!=null) {
			for(Long id : storeDto.getBooks()) {
				store.getBook().add(getBook(id));
			}
		}
		return StoreMapper.entityToDto(repository.save(store));
		
	}

	@Override
	public StoreDto getStore(Long id) {
		// TODO Auto-generated method stub
		return StoreMapper.entityToDto(repository.getById(id));
	}
	
	private Book getBook(Long id) {
		return bookRepository.getById(id);
	}

}
