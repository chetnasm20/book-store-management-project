package com.bookstore.books.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bookstore.books.entity.MBookList;
@Repository
public interface myBokkRepository extends JpaRepository<MBookList,Integer>{

}
