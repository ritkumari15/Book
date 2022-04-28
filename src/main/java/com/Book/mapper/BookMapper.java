package com.Book.mapper;

import java.util.HashSet;
import java.util.Set;

import com.Book.dto.BookDto;
import com.Book.dto.ImmutableBookDto;
import com.Book.dto.StoreDto;
import com.Book.entity.Book;
import com.Book.entity.Store;

public interface BookMapper {
	public static BookDto entityToDto(Book book) {
		return ImmutableBookDto.builder()
				.id(book.getId())
				.name(book.getName())
				.stores(getBookIds(book.getStore()))
				.build();
	}
	
	private static Set<Long> getBookIds(Set<Store> store) {
		Set<Long> storeId = new HashSet<>();
		if(store!=null)
		for(Store b : store) {
			
			storeId.add(b.getId());
		}
		
		return storeId;
		
	}
}
