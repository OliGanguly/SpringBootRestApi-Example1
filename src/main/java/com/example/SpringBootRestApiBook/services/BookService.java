package com.example.SpringBootRestApiBook.services;

import com.example.SpringBootRestApiBook.Entities.Book;
import com.example.SpringBootRestApiBook.dao.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class BookService {
    //Interact with dao layer
//    private static List<Book> list = new ArrayList<>();
//
//    static {
//        list.add(new Book(2, "Js", "JavaScript"));
//        list.add(new Book(3, "All about Python", "Python"));
//        list.add(new Book(4, "All about Java", "Java"));
//        list.add(new Book(5, "English Grammer", "English"));
//    }
 @Autowired
    private BookRepository bookRepository;
    public List<Book> getAllBooks() {
        List<Book> all = this.bookRepository.findAll();
        return all;
    }

    public Book getBookById(int id) {
        Book b = null;
        try{
//            b = list.stream().filter(e -> e.getBookId() == id).findFirst().get();
             b = bookRepository.findById(id);
        }catch (Exception e){
            e.printStackTrace();
        }
            return b;

    }

    public Book addBook(Book b) {
        Book result = bookRepository.save(b);
        return result;
    }

    public void delete(int id) {
//        Book b = list.stream().filter(e -> e.getBookId() == id).findFirst().get();
//        list.remove(b);
        bookRepository.deleteById(id);

    }

//    public Book update(int id, Book book) {
//        Book b = list.stream().filter(e -> e.getBookId() == id).findFirst().get();
//        b.setBookId(book.getBookId());
//        b.setBookName(book.getBookName());
//        b.setSubject(book.getSubject());
//        list.add(b);
//        return b;
//    }

//    public Book updateBook(int id, Book book) {
//        list = list.stream().map(b -> {
//            if (b.getBookId() == id) {
//                b.setBookId(book.getBookId());
//                b.setBookName(book.getBookName());
//                b.setSubject(book.getSubject());
//            }
//            return b;
//        }).collect(Collectors.toList());
//        //collect it as a List
//
//        return book;
//    }
public Book updateBook(int id, Book book) {
    Book b = bookRepository.findById(id);
    b.setBookName(book.getBookName());
    b.setSubject(book.getSubject());
    Book res = bookRepository.save(b);
    return res;
}
}
