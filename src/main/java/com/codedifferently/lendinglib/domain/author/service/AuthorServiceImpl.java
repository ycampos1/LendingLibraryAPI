package com.codedifferently.lendinglib.domain.author.service;

import com.codedifferently.lendinglib.domain.author.exceptions.AuthorNotFoundException;
import com.codedifferently.lendinglib.domain.author.models.Author;
import com.codedifferently.lendinglib.domain.author.repos.AuthorRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AuthorServiceImpl implements AuthorService{

    private AuthorRepo authorRepo;

    @Autowired
    public AuthorServiceImpl(AuthorRepo authorRepo){
        this.authorRepo = authorRepo;
    }

    @Override
    public Author create(Author author) {
        return authorRepo.save(author);
    }

    @Override
    public Author getById(Long id) throws AuthorNotFoundException {
        Optional<Author> authorOptional = authorRepo.findById(id);
        if(authorOptional.isEmpty())
            throw new AuthorNotFoundException();
        return authorOptional.get();
    }

    @Override
    public Iterable<Author> getByLastName(String lastName) {
        return authorRepo.findByLastName(lastName);
    }
}
