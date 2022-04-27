package com.codedifferently.lendinglib.domain.lendingTransaction.service;

import com.codedifferently.lendinglib.domain.books.exception.BookCheckOutException;
import com.codedifferently.lendinglib.domain.books.exception.BookNotFoundException;
import com.codedifferently.lendinglib.domain.books.models.Book;
import com.codedifferently.lendinglib.domain.books.services.BookService;
import com.codedifferently.lendinglib.domain.lendingTransaction.exceptions.LendingTransactionException;
import com.codedifferently.lendinglib.domain.lendingTransaction.model.LendingTransaction;
import com.codedifferently.lendinglib.domain.lendingTransaction.repo.LendingTransactionRepo;
import com.codedifferently.lendinglib.domain.members.exceptions.MemberNotFoundException;
import com.codedifferently.lendinglib.domain.members.models.Member;
import com.codedifferently.lendinglib.domain.members.models.services.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LendingTransactionServiceImpl implements LendingTransactionService{
    private BookService bookService;
    private MemberService memberService;
    private LendingTransactionRepo lendingTransactionRepo;

    @Autowired
    public LendingTransactionServiceImpl(BookService bookService,
                                         MemberService memberService,
                                         LendingTransactionRepo lendingTransactionRepo){
        this.bookService = bookService;
        this.memberService = memberService;
        this.lendingTransactionRepo = lendingTransactionRepo;
    }

    @Override
    public LendingTransaction checkBookOut(Long memberId, Long bookId) throws LendingTransactionException {
        try {
            Member member = memberService.getById(memberId);
            Book book = bookService.getById(bookId);
            if(member.getAllowedToBorrow()  )
                throw new LendingTransactionException("Member not allowed to borrow");
            book = bookService.checkOut(book);
            LendingTransaction lendingTransaction = new LendingTransaction(book, member);
            return lendingTransactionRepo.save(lendingTransaction);
        }catch (MemberNotFoundException e) {
           throw new LendingTransactionException("Book not found");
        }catch (BookNotFoundException e) {
            throw new LendingTransactionException("Member not found");
        } catch (BookCheckOutException e) {
            throw new LendingTransactionException("Book could not be checked out");
        }
    }

    @Override
    public void checkBookIn(Long lendingTransactionId) {

    }


}
