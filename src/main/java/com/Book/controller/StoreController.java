package com.Book.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Book.dto.StoreDto;
import com.Book.service.StoreService;
@RestController
@RequestMapping("/store")
public class StoreController {
	
	@Autowired
	private StoreService service;
	
	@PostMapping("/add")
	public ResponseEntity<?> createStore(@RequestBody StoreDto storeDto){
		StoreDto storeDto2 = service.addStore(storeDto);
		if (storeDto2==null) {
			return new ResponseEntity<String>("Internal server error", HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<StoreDto>(storeDto2, HttpStatus.CREATED);
	}

}
