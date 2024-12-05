package com.cts.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cts.entity.Book;
import com.cts.repository.BookRepository;

@Service
public class BookService {

	@Autowired
	BookRepository bookRepository;
	
	public List<Book> findAll()
	{
		return bookRepository.findAll();
	}
	
	public Book findById(Long id)
	{
		return bookRepository.findById(id).orElse(null);
	}
	
	public Book create(Book book)
	{
		return bookRepository.save(book);
	}
	
	public List<Book> findByPublishedAfter(LocalDate date)
	{
		return bookRepository.findByPublishedAfter(date);
	}
	
	public void deleteById(Long id)
	{
		bookRepository.deleteById(id);
	}
	
	public List <Book> findByTitle(String title)
	{
		return bookRepository.findByTitle(title);
	}
}
