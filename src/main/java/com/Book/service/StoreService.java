package com.Book.service;

import com.Book.dto.StoreDto;

public interface StoreService {
	
	
	public StoreDto addStore(StoreDto storeDto);
	
	public StoreDto getStore(Long id);

}
