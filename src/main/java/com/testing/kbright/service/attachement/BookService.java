package com.testing.kbright.service.attachement;

import com.testing.kbright.models.Book;
import java.util.List;

/**
 * Interface for BookService which provides methods for registering, updating,
 * finding and deleting books.
 */
public interface BookService {

    /**
     * Registers a new book.
     * 
     * @param book the book to register
     * @return the registered book
     */
    Book register(Book book);

    /**
     * Updates a book with the specified id.
     * 
     * @param book the updated book
     * @param id   the id of the book to update
     * @return the updated book
     */
    Book update(Book book, Integer id);

    /**
     * Finds a book with the specified id.
     * 
     * @param id the id of the book to retrieve
     * @return the book with the specified id
     */
    Book findById(Integer id);

    /**
     * Deletes a book with the specified id.
     * 
     * @param id the id of the book to delete
     */
    void deleteById(Integer id);

    /**
     * Retrieves a list of all books.
     * 
     * @return a list of all books
     */
    List<Book> getAll();
}

