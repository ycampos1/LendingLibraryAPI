package com.codedifferently.lendinglib.domain.lendingTransaction.repo;

import com.codedifferently.lendinglib.domain.lendingTransaction.model.LendingTransaction;
import org.springframework.data.repository.CrudRepository;

public interface LendingTransactionRepo extends CrudRepository<LendingTransaction, Long> {
}
