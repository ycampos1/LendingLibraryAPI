package com.codedifferently.lendinglib.domain.books.services;

import com.codedifferently.lendinglib.domain.author.service.AuthorService;
import com.codedifferently.lendinglib.domain.books.exception.BookNotFoundException;
import com.codedifferently.lendinglib.domain.books.models.Book;
import com.codedifferently.lendinglib.domain.books.repos.BookRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class BookServiceImpl implements BookService{
    private BookRepo bookRepo;
    private AuthorService authorService;

    @Autowired
    public BookServiceImpl(BookRepo repo, AuthorService authorService){
        this.authorService = authorService;
        this.bookRepo = repo;
    }

    @Override
    public Book checkOut(Book book) {
        book.setInLibrary(true);
        return bookRepo.save(book);
    }

    @Override
    public void returnBook(Book book) {
        book.setInLibrary(false);
        bookRepo.save(book);
    }

    @Override
    public Boolean isBookAvailable(String title) throws BookNotFoundException {
        Optional<Book> bookOptional = bookRepo.findByTitle(title);
        if(bookOptional.isEmpty())
            throw new BookNotFoundException();
        Book book = bookOptional.get();
        return book.getInLibrary();
    }

    @Override
    public Book create(Book book) {
        return bookRepo.save(book);
    }

    @Override
    public Book getById(Long id) throws BookNotFoundException {
        Optional<Book> bookOptional = bookRepo.findById(id);
        if(bookOptional.isEmpty())
            throw new BookNotFoundException();
        return bookOptional.get();
    }

    @Override
    public Book getByTitle(String title) throws BookNotFoundException {
        Optional<Book> bookOptional = bookRepo.findByTitle(title);
        if(bookOptional.isEmpty())
            throw new BookNotFoundException();
        return bookOptional.get();
    }

    @Override
    public Book update(Book book) throws BookNotFoundException {
        Long id = book.getId();
        Optional<Book> bookOptional = bookRepo.findById(id);
        if(bookOptional.isEmpty())
            throw new BookNotFoundException();
        return bookRepo.save(book);
    }

    @Override
    public void delete(Long id) throws BookNotFoundException {
        Optional<Book> bookOptional = bookRepo.findById(id);
        if(bookOptional.isEmpty())
            throw new BookNotFoundException();
        bookRepo.delete(bookOptional.get());
    }
}
