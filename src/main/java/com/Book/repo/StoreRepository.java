package com.Book.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Book.entity.Store;

@Repository
public interface StoreRepository  extends JpaRepository<Store, Long>{

}
