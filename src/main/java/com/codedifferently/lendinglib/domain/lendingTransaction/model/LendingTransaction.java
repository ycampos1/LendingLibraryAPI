package com.codedifferently.lendinglib.domain.lendingTransaction.model;

import com.codedifferently.lendinglib.domain.books.models.Book;
import com.codedifferently.lendinglib.domain.members.models.Member;
import lombok.*;

import javax.persistence.*;

@Entity
@Data
@ToString
@NoArgsConstructor
@RequiredArgsConstructor
public class LendingTransaction {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NonNull
    @ManyToOne(cascade = CascadeType.DETACH)
    private Book book;

    @NonNull
    @ManyToOne(cascade = CascadeType.ALL)
    private Member member;
}
