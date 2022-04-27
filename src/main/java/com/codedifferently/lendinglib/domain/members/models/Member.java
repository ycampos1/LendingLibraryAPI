package com.codedifferently.lendinglib.domain.members.models;

import com.codedifferently.lendinglib.domain.books.models.Book;
import com.codedifferently.lendinglib.domain.lendingTransaction.model.LendingTransaction;
import lombok.*;

import javax.persistence.*;
import java.util.Set;

@Entity
@NoArgsConstructor
@RequiredArgsConstructor
@Data
@ToString
public class Member {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NonNull
    private String firstName;

    @NonNull
    private String lastName;

    @OneToMany(targetEntity = LendingTransaction.class, cascade = CascadeType.ALL, fetch = FetchType.EAGER, orphanRemoval = true)
    Set<LendingTransaction> lendingTransactions;

    @NonNull
    private Boolean allowedToBorrow;
}
