package com.so.csoc.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.so.csoc.data.entity.Book;

public interface BookRepository extends JpaRepository<Book, String> {

}
