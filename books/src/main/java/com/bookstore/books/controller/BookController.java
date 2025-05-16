package com.bookstore.books.controller;
import com.bookstore.books.service.*;

import java.awt.print.Book;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.bookstore.books.entity.Books;
import com.bookstore.books.entity.MBookList;
import com.bookstore.books.service.BookService;
import org.springframework.ui.Model;

import java.util.*;
@Controller
public class BookController {

	
	@Autowired
	private BookService service;
	
	@Autowired
	private MyBookListService m;
	
	@GetMapping("/")
	public String home()
	{
		return"home";
	}
	
	
	@GetMapping("/book_register")
	public String bookRegister()
	{
		return "bookRegister";
	}

@GetMapping("/available_books")
public ModelAndView getAllBooks()
{
	List<Books>list=service.getAllBook();
	//ModelAndView m=new ModelAndView();
	//m.setViewName("bookList");
	//m.addObject("book",list);
	return new ModelAndView("bookList","book",list);
}

@PostMapping("/save")
public String save(@ModelAttribute Books b) {
	service.save(b);
	return "redirect:/available_books";
}

@GetMapping("/my_books")
public String getMyBooks(Model model) 
{
	List<MBookList>list=m.getAllMyBooks();
model.addAttribute("book",list);
	return "myBooks";
}


@RequestMapping("/mylist/{id}")
public String getMyList(@PathVariable ("id") int id)
{
	Books b=service.GetBookById(id);
	MBookList m1=new MBookList(b.getId(), b.getName(), b.getAuthor(), b.getPrice());
	m.saveMyBooks(m1);
	return "redirect:/my_books";
	
}

@RequestMapping("/editBook/{id}")
public String editBook(@PathVariable("id") int id ,Model model)
{
	Books b=service.GetBookById(id);
	model.addAttribute("book",b);
return "bookEdit";
}

@RequestMapping("/deleteBook/{id}")
public String deleteBook(@PathVariable("id") int id,Model model)
{
	service.deleteById(id);
	return "redirect:/available_books";
}
}
