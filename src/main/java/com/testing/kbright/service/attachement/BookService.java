package com.testing.kbright.service.attachement;

import com.testing.kbright.models.Book;
import java.util.List;

public interface BookService {
    Book register(Book book);
    Book update(Book book,Integer id);
    Book findById(Integer id);
    void deleteById(Integer id);
    List<Book> getAll();
}
