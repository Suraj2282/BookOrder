package com.cts.controller;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.cts.entity.Book;
import com.cts.service.BookService;

@RestController
@RequestMapping("/book")
public class BookController {
	
	@Autowired
	private BookService bookService;
	
	@GetMapping
	public List<Book> findAll()
	{
		return bookService.findAll();
		
	}
	
	@GetMapping("/{id}")
	public Book findById(@PathVariable Long id)
	{
		return bookService.findById(id);
	}
	
	@ResponseStatus(HttpStatus.CREATED)//201
	@PostMapping
	public Book create(@RequestBody Book book)
	{
		return bookService.create(book);
	}
	
	@ResponseStatus(HttpStatus.NO_CONTENT) //204
	@DeleteMapping("/{id}")
	public void deleteById(@PathVariable Long id)
	{
		bookService.deleteById(id);
	}
	
	@GetMapping("/find/find-by-title/{title}")
	public List<Book> findByTitle(@PathVariable String title)
	{
		return bookService.findByTitle(title);
	}
	
	@GetMapping("/find/bydate/{date}")
	public List<Book> findByPublishedAfterDate(@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date)
	{
		return bookService.findByPublishedAfter(date);
	}

}

