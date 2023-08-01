package com.example.SpringBootRestApiBook.Entities;

import jakarta.persistence.*;

/*
* Entity defines database
*
* */
@Entity
@Table(name = "Book")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "book_id")
    private int bookId;
    private String bookName;
    private String subject;

    //Non primitive data type
    /*
    * How to map?
    * One - book has only one author
    * unidirectional flow
    * book to author
    * cascade - automatically save author automatically
    * */

    @OneToOne(fetch = FetchType.EAGER , cascade = CascadeType.MERGE , targetEntity = Author.class)
    @JoinColumn(name = "authorId", referencedColumnName = "author_id",nullable = false)
    private Author author;


    public Book() {
    }

    public Book(int bookId, String bookName, String subject, Author author) {
        this.bookId = bookId;
        this.bookName = bookName;
        this.subject = subject;
        this.author = author;
    }

    public int getBookId() {
        return bookId;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    @Override
    public String toString() {
        return "Book{" +
                "bookId=" + bookId +
                ", bookName='" + bookName + '\'' +
                ", subject='" + subject + '\'' +
                ", author=" + author +
                '}';
    }
}
