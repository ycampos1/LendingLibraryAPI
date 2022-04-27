package com.codedifferently.lendinglib.domain.members.models.services;

import com.codedifferently.lendinglib.domain.lendingTransaction.model.LendingTransaction;
import com.codedifferently.lendinglib.domain.members.exceptions.MemberNotFoundException;
import com.codedifferently.lendinglib.domain.members.models.Member;

public interface MemberService {
    Member create(Member member);
    Member getById(Long id) throws MemberNotFoundException;
    Member getByFullName(String firstName, String lastName) throws MemberNotFoundException;
    Member update(Member member) throws MemberNotFoundException;
    void delete(Long id) throws MemberNotFoundException;
    Iterable<LendingTransaction> getAllTransactions(Long id);
    void restrictMemberPrivileges(Member member);
    void restoreMemberPrivileges(Member member);
}
