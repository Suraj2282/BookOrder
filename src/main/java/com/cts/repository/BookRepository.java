package com.cts.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
//import org.springframework.data.repository.query.Param;

import com.cts.entity.Book;

public interface BookRepository extends JpaRepository<Book, Long> {
	@Query("select b from Book b where b.title=?1")
	List<Book> findByTitle(String title);
	
	@Query("select b from Book b where b.publishDate=?1 ")
	public List<Book> findByPublishedAfter(LocalDate date);

}
