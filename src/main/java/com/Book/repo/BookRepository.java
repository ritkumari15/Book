package com.Book.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.Book.entity.Book;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {
	
	@Query("select b from Book b where b.name=?1")
	public Book getByName(String name);

}
