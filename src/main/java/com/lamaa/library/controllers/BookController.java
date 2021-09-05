package com.lamaa.library.controllers;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import com.lamaa.library.domain.Book;
import com.lamaa.library.repositories.BookRepository;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class BookController {
    private final BookRepository bookRepository;

    public BookController(BookRepository bookRepository){
        this.bookRepository = bookRepository;
    }

    @RequestMapping("/books")
    public String getBooks(Model model){

        List<Book> books = StreamSupport.stream(bookRepository.findAll().spliterator(),false).collect(Collectors.toList());

        model.addAttribute("books", books);

        return "books/list";
    }
}
