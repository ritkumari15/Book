package com.Book.mapper;

import java.util.HashSet;
import java.util.Set;

import com.Book.dto.ImmutableStoreDto;
import com.Book.dto.StoreDto;
import com.Book.entity.Book;
import com.Book.entity.Store;

public interface StoreMapper {

	public static StoreDto entityToDto(Store store) {
		return ImmutableStoreDto.builder()
				.id(store.getId())
				.name(store.getName())
				.books(getStoreIds(store.getBook()))
				.build();
	}
	
	private static Set<Long> getStoreIds(Set<Book> book) {
		Set<Long> storeId = new HashSet<>();
		for(Book b : book) {
			
			storeId.add(b.getId());
		}
		
		return storeId;
		
	}
	
}
