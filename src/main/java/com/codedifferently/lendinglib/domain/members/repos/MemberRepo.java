package com.codedifferently.lendinglib.domain.members.repos;

import com.codedifferently.lendinglib.domain.members.models.Member;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface MemberRepo extends CrudRepository<Member, Long> {
    Optional<Member> findByFirstNameAndLastName(String firstName, String lastName);
}
