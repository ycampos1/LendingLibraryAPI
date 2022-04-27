package com.codedifferently.lendinglib.domain.author.models;

import com.codedifferently.lendinglib.domain.books.models.Book;
import lombok.*;

import javax.persistence.*;
import java.util.Set;

@Entity
@NoArgsConstructor
@RequiredArgsConstructor
@Data
@ToString
public class Author {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @NonNull
    private String firstName;
    @NonNull
    private String lastName;

    @OneToMany(targetEntity = Book.class, cascade = CascadeType.ALL, fetch = FetchType.EAGER, orphanRemoval = true)
    @JoinColumn(name="authorId", referencedColumnName = "id")
    private Set<Book> books;

}
