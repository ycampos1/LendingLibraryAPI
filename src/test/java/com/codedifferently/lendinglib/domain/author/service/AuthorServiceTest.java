package com.codedifferently.lendinglib.domain.author.service;

import com.codedifferently.lendinglib.domain.author.exceptions.AuthorNotFoundException;
import com.codedifferently.lendinglib.domain.author.models.Author;
import com.codedifferently.lendinglib.domain.author.repos.AuthorRepo;
import com.codedifferently.lendinglib.domain.books.models.Book;
import com.codedifferently.lendinglib.domain.lendingTransaction.model.LendingTransaction;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import static org.mockito.BDDMockito.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.time.LocalDate;
import java.util.Optional;

@SpringBootTest
@ExtendWith(SpringExtension.class)
public class AuthorServiceTest {

    @MockBean
    private AuthorRepo authorRepo;

    @Autowired
    private AuthorService authorService;
    private Author testAuthorIn;
    private Author testAuthorOut;

    @BeforeEach
    public void setUp(){
        testAuthorIn = new Author("Jack","Kirby");
        testAuthorOut = new Author("Jack","Kirby");
        testAuthorOut.setId(1l);

    }

    @Test
    @DisplayName("Create author test 01")
    public void createAuthorTest01(){
        doReturn(testAuthorOut)
                .when(authorRepo)
                .save(testAuthorIn);
        Author actualAuthor = authorService.create(testAuthorIn);
        Assertions.assertNotNull(actualAuthor);
        Assertions.assertEquals(1l, actualAuthor.getId());
    }

    @Test
    public void getByIdTest01() throws AuthorNotFoundException {
        Author expected = new Author("Stan", "Lee");
        expected.setId(2l);
        doReturn(Optional.of(expected)).when(authorRepo).findById(2l);
        Author actual = authorService.getById(2l);
        Assertions.assertEquals(actual.toString(), expected.toString());
    }

    @Test
    public void getByIdTest02(){
        doReturn(Optional.empty())
                .when(authorRepo)
                .findById(2l);
        Assertions.assertThrows(AuthorNotFoundException.class,()->{
            authorService.getById(2l);
        });
    }
}
