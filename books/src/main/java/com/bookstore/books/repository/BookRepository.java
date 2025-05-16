package com.bookstore.books.repository;



import java.awt.print.Book;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.bookstore.books.entity.*;
@Repository
public interface BookRepository extends JpaRepository<Books,Integer> {

	void save(Book b);



	

}
