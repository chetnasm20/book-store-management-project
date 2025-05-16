package com.bookstore.books.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bookstore.books.entity.*;
import com.bookstore.books.repository.BookRepository;

import java.awt.print.Book;
import java.util.*;
@Service
public class BookService {

	@Autowired
	private BookRepository bookRepo;
	
	public void save(Books b) {
		bookRepo.save(b);
	}

	public List<Books> getAllBook() {
		
		return bookRepo.findAll();
	}
	public Books GetBookById(int id)
	{
		return bookRepo.findById(id).get();
	}

	public void deleteById(int id) {
		bookRepo.deleteById(id);
		
	}

	

}
