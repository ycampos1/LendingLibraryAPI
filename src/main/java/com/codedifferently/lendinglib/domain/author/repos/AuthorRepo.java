package com.codedifferently.lendinglib.domain.author.repos;

import com.codedifferently.lendinglib.domain.author.models.Author;
import org.springframework.data.repository.CrudRepository;


public interface AuthorRepo extends CrudRepository<Author, Long> {
    Iterable<Author> findByLastName(String lastName);
}
