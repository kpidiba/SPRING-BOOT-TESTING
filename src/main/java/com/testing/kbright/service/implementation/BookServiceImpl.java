package com.testing.kbright.service.implementation;

import org.springframework.stereotype.Service;
import java.util.List;

import com.testing.kbright.models.Book;
import com.testing.kbright.repository.BookRepository;
import com.testing.kbright.service.attachement.BookService;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
/**
 * Implementation of the BookService interface that uses the BookRepository to
 * interact with the database. Provides methods for registering, updating,
 * finding
 * and deleting books.
 */
public class BookServiceImpl implements BookService {
    private final BookRepository repository;

    /**
     * Registers a new book in the database.
     * 
     * @param book the book to register
     * @return the registered book
     */
    @Override
    public Book register(Book book) {
        return this.repository.save(book);
    }

    /**
     * Updates a book in the database with the specified id.
     * 
     * @param book the updated book
     * @param id   the id of the book to update
     * @return the updated book
     */
    @Override
    public Book update(Book book, Integer id) {
        book.setId(id);
        return this.repository.save(book);
    }

    /**
     * Finds a book with the specified id in the database.
     * 
     * @param id the id of the book to retrieve
     * @return the book with the specified id
     */
    @Override
    public Book findById(Integer id) {
        return this.repository.findById(id).get();
    }

    /**
     * Deletes a book with the specified id from the database.
     * 
     * @param id the id of the book to delete
     */
    @Override
    public void deleteById(Integer id) {
        Book book = this.repository.findById(id).get();
        this.repository.delete(book);
    }

    /**
     * Retrieves a list of all books from the database.
     * 
     * @return a list of all books
     */
    @Override
    public List<Book> getAll() {
        return this.repository.findAll();
    }

}