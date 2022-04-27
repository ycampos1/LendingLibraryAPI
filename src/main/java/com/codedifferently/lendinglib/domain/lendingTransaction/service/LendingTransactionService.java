package com.codedifferently.lendinglib.domain.lendingTransaction.service;

import com.codedifferently.lendinglib.domain.lendingTransaction.exceptions.LendingTransactionException;
import com.codedifferently.lendinglib.domain.lendingTransaction.model.LendingTransaction;

public interface LendingTransactionService {
    LendingTransaction checkBookOut(Long memberId, Long bookId) throws LendingTransactionException;
    void checkBookIn(Long lendingTransactionId);
}
