package com.codedifferently.lendinglib.domain.members.models.services;

import com.codedifferently.lendinglib.domain.lendingTransaction.model.LendingTransaction;
import com.codedifferently.lendinglib.domain.members.exceptions.MemberNotFoundException;
import com.codedifferently.lendinglib.domain.members.models.Member;
import com.codedifferently.lendinglib.domain.members.repos.MemberRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Service
public class MemberServiceImpl implements MemberService{
    private MemberRepo memberRepo;

    @Autowired
    public MemberServiceImpl(MemberRepo memberRepo){
        this.memberRepo = memberRepo;
    }

    @Override
    public Member create(Member member) {
        return memberRepo.save(member);
    }

    @Override
    public Member getById(Long id) throws MemberNotFoundException {
        Optional<Member> memberOptional = memberRepo.findById(id);
        if(memberOptional.isEmpty())
            throw new MemberNotFoundException();
        return memberOptional.get();
    }

    @Override
    public Member getByFullName(String firstName, String lastName) throws MemberNotFoundException {
        Optional<Member> memberOptional = memberRepo.findByFirstNameAndLastName(firstName, lastName);
        if(memberOptional.isEmpty())
            throw new MemberNotFoundException();
        return memberOptional.get();
    }

    @Override
    public Member update(Member member) throws MemberNotFoundException {
        Long id = member.getId();
        Optional<Member> memberOptional = memberRepo.findById(id);
        if(memberOptional.isEmpty())
            throw new MemberNotFoundException();
        return memberRepo.save(member);
    }

    @Override
    public void delete(Long id) throws MemberNotFoundException {
        Optional<Member> memberOptional = memberRepo.findById(id);
        if(memberOptional.isEmpty())
            throw new MemberNotFoundException();
        memberRepo.delete(memberOptional.get());
    }

    @Override
    public Iterable<LendingTransaction> getAllTransactions(Long id) {
        return null;
    }

    @Override
    public void restrictMemberPrivileges(Member member) {
        member.setAllowedToBorrow(false);
        memberRepo.save(member);
    }

    @Override
    public void restoreMemberPrivileges(Member member) {
        member.setAllowedToBorrow(true);
        memberRepo.save(member);
    }
}
