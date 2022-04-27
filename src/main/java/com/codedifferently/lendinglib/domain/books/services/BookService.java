package com.codedifferently.lendinglib.domain.books.services;

import com.codedifferently.lendinglib.domain.books.exception.BookCheckOutException;
import com.codedifferently.lendinglib.domain.books.exception.BookNotFoundException;
import com.codedifferently.lendinglib.domain.books.models.Book;

public interface BookService {
    Book checkOut(Book book) throws BookCheckOutException;
    void returnBook(Book book);
    Boolean isBookAvailable(String title) throws BookNotFoundException;
    Book create(Book book);
    Book getById(Long id) throws BookNotFoundException;
    Book getByTitle(String title) throws BookNotFoundException;
    Book update(Book book) throws BookNotFoundException;
    void delete(Long id) throws BookNotFoundException;
}

