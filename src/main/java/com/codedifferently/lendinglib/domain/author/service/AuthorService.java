package com.codedifferently.lendinglib.domain.author.service;

import com.codedifferently.lendinglib.domain.author.exceptions.AuthorNotFoundException;
import com.codedifferently.lendinglib.domain.author.models.Author;

public interface AuthorService {
    Author create(Author author);
    Author getById(Long id) throws AuthorNotFoundException;
    Iterable<Author> getByLastName(String lastName);
}
