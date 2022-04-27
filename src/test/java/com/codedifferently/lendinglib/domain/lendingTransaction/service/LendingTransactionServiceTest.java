package com.codedifferently.lendinglib.domain.lendingTransaction.service;

import com.codedifferently.lendinglib.domain.books.models.Book;
import com.codedifferently.lendinglib.domain.books.services.BookService;
import com.codedifferently.lendinglib.domain.lendingTransaction.exceptions.LendingTransactionException;
import com.codedifferently.lendinglib.domain.lendingTransaction.model.LendingTransaction;
import com.codedifferently.lendinglib.domain.members.exceptions.MemberNotFoundException;
import com.codedifferently.lendinglib.domain.members.models.Member;
import com.codedifferently.lendinglib.domain.members.models.services.MemberService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.BDDMockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.time.LocalDate;

public class LendingTransactionServiceTest {

    @Autowired
    private LendingTransactionService lendingTransactionService;

    @MockBean
    private MemberService memberService;

    @MockBean
    private BookService bookService;

    private Member testMember;
    private Book testBook;
    private LendingTransaction testTransactionIn;
    private LendingTransaction testTransactionOut;

    @BeforeEach
    public void setUp(){
        testBook = new Book("Title of book", LocalDate.now());
        testBook.setId(9l);
        testMember = new Member("Bob", "Dole", true);
        testMember.setId(5l);
        testTransactionIn = new LendingTransaction(testBook,testMember);
        testTransactionOut = new LendingTransaction(testBook,testMember);
        testTransactionOut.setId(1l);
    }

}
