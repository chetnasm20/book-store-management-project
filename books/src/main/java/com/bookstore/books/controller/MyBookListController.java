package com.bookstore.books.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bookstore.books.service.MyBookListService;

@Controller
public class MyBookListController {
	@Autowired
	private MyBookListService s;
	
	
@RequestMapping("/deleteMyList/{id}")
	public String deleteMyList(@PathVariable ("id") int id)
	{
	s.deleteById(id);
		return "redirect:/my_books";
	}
}
