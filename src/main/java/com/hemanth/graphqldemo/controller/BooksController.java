package com.hemanth.graphqldemo.controller;

import com.hemanth.graphqldemo.model.Book;
import com.hemanth.graphqldemo.repository.BookRepository;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.graphql.data.method.annotation.SchemaMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class BooksController {

    private final BookRepository bookRepository;

    public BooksController(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }


   /* @SchemaMapping(typeName = "Query",value = "allBooks")
    public List<Book> findAllBooks(){
        return bookRepository.allBooks();
    }*/

    @QueryMapping
    public List<Book> allBooks(){
        return bookRepository.allBooks();
    }

    @QueryMapping
    public Book findOne(@Argument Integer id){
        return bookRepository.findOne(id);
    }
}
