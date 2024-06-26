package com.testing.kbright.controller;

import org.springframework.web.bind.annotation.RestController;

import com.testing.kbright.models.Book;
import com.testing.kbright.service.attachement.BookService;
import lombok.AllArgsConstructor;
import java.util.List;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
@AllArgsConstructor
@RequestMapping("/book")
public class BookController {
    private final BookService service;

    /**
     * This method handles GET requests to the root path "/book" and returns a list
     * of all books.
     * 
     * @return a list of all books
     */
    @GetMapping
    public ResponseEntity<List<Book>> index() {
        List<Book> books = this.service.getAll();
        return ResponseEntity.ok(books);
    }

    /**
     * This method handles GET requests to "/book/{id}" and returns a book with the
     * specified id.
     * 
     * @param id the id of the book to retrieve
     * @return the book with the specified id
     */
    @GetMapping(value = "/{id}", produces = "application/json")
    public ResponseEntity<Book> getBookById(@PathVariable("id") Integer id) {
        try {
            Book book = this.service.findById(id);
            return ResponseEntity.ok(book);
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }

    /**
     * This method handles POST requests to "/book" and registers a new book.
     * 
     * @param book the book to register
     * @return the registered book
     */
    @PostMapping
    public ResponseEntity<Void> register(@RequestBody Book book) {
        this.service.register(book);
        return ResponseEntity.ok().build();
    }

    /**
     * This method handles PUT requests to "/book/{id}" and updates a book.
     * 
     * @param book the updated book
     * @param id   the id of the book to update
     * @return the updated book
     */
    @PutMapping("/{id}")
    public ResponseEntity<Void> update(@RequestBody Book book, @PathVariable("id") Integer id) {
        try {
            this.service.update(book, id);
        return ResponseEntity.ok().build();
        } catch (Exception e) {
            return ResponseEntity.status(500).build();
        }
    }

    /**
     * This method handles DELETE requests to "/book/{id}" and deletes a book with
     * the specified id.
     * 
     * @param id the id of the book to delete
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") Integer id) {
        this.service.deleteById(id);
        return ResponseEntity.ok().build();
    }

}
