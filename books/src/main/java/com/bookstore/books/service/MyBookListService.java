package com.bookstore.books.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bookstore.books.entity.MBookList;
import com.bookstore.books.repository.myBokkRepository;

@Service
public class MyBookListService {
@Autowired
private myBokkRepository mb;

public void saveMyBooks(MBookList book)
{
	mb.save(book);
}
public List<MBookList>getAllMyBooks()
{
	return mb.findAll();
}
public void deleteById(int id)
{
	 mb.deleteById(id);
}
}
