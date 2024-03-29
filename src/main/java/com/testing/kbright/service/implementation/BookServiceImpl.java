package com.testing.kbright.service.implementation;

import org.springframework.stereotype.Service;
import java.util.List;

import com.testing.kbright.models.Book;
import com.testing.kbright.repository.BookRepository;
import com.testing.kbright.service.attachement.BookService;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class BookServiceImpl implements BookService{
    private final BookRepository repository;
    @Override
    public Book register(Book book) {
        return this.repository.save(book);
    }

    @Override
    public Book update(Book book, Integer id) {
        book.setId(id);
        return this.repository.save(book);
    }

    @Override
    public Book findById(Integer id) {
        return this.repository.findById(id).get();
    }

    @Override
    public void deleteById(Integer id) {
        Book book = this.repository.findById(id).get();
        this.repository.delete(book);
    }

    @Override
    public List<Book> getAll() {
        return this.repository.findAll();
    }

}
