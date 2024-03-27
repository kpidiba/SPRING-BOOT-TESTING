package com.testing.kbright.controller;

import org.springframework.web.bind.annotation.RestController;

import com.testing.kbright.models.Book;
import com.testing.kbright.repository.BookRepository;

import lombok.AllArgsConstructor;
import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;


@RestController
@AllArgsConstructor
public class BookController {
    private final BookRepository repository;

    @GetMapping
    public List<Book> index() {
        return this.repository.findAll();
    }
    
}
