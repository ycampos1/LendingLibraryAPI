package com.codedifferently.lendinglib.domain.books.repos;

import com.codedifferently.lendinglib.domain.books.models.Book;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface BookRepo extends CrudRepository<Book, Long> {
    Optional<Book> findByTitle(String title);
}
