package com.example.SpringBootRestApiBook.dao;

import com.example.SpringBootRestApiBook.Entities.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends JpaRepository<Book,Integer> {
    public Book findById(int id);
}
