package com.testing.kbright.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.testing.kbright.models.Book;

public interface BookRepository extends JpaRepository<Book,Integer> {
    
}
