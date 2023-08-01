package com.example.SpringBootRestApiBook.Controller;

import com.example.SpringBootRestApiBook.Entities.Book;
import com.example.SpringBootRestApiBook.services.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

//Handling HttpStatus
/*
* post - 201
* get  - 200
* put  -200
* delete - 204 (No content means deleeted)
* get  - 200
* */
@RestController
public class BookController {
    @Autowired
    private BookService bookservice;
//    @RestController = @Controller + @ResponseBody
//    @RequestMapping(value = "/get",method = RequestMethod.GET)
    @GetMapping("/hello")
    public String Hello(){
        return "Hello Book";
    }


    /*Spring Boot automatically converts
    * Book object to json - Jaction dependency
    * */
    @GetMapping("/books")
    public ResponseEntity<List<Book>> getBooks(){
        List<Book> allBooks = bookservice.getAllBooks();
        if(allBooks.size()<=0){
            //status Not Found
            return  ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.of(Optional.of(allBooks));
    }
    @GetMapping("/books/{id}")
    public ResponseEntity<Book> getSingleBook(@PathVariable("id") int id){
        Book bookById = bookservice.getBookById(id);
            if (bookById==null)
            {
                ResponseEntity.status(HttpStatus.NOT_FOUND).build();
            }
        if (bookById == null)
            throw new NullPointerException();

        return ResponseEntity.of(Optional.of(bookById));

    }
    @PostMapping("/addBook")
    public Book addBook(@RequestBody Book b){
      Book book = this.bookservice.addBook(b);
      return  book;
    }

//    @RequestBody - map data from form
    //Automatically map the data (which is coming from requestBody as a JSON
    //automaticall deserilize that data and map with book class data
//    @PostMapping("/addBook")
//    public ResponseEntity<Book> addBook2(@RequestBody Book b){
//        Book book = this.bookservice.addBook(b);
//        return book;
//    }
    @DeleteMapping("/deleteBook/{bookId}")
    public void deleteBook(@PathVariable("bookId") int bookId){
         this.bookservice.delete(bookId);
    }
    @PutMapping("/updateBook/{bookId}")
    public Book updateBook(@PathVariable("bookId") int bookId,@RequestBody Book b){
        Book update = this.bookservice.updateBook(bookId, b);
        return update;
    }







}
