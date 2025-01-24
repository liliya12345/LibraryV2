package org.libraryv2.model;

import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

@Table(name="books")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private String title;
    @Column
    private String description;
    @Column
    private String publisher;
    @Column
    private Integer year;
    @Enumerated(EnumType.STRING)
    private Language language;
    @ManyToMany
    private List<Author> author;
    @ManyToOne
    private Category category;
    @OneToMany(cascade = CascadeType.REFRESH, fetch = FetchType.EAGER, mappedBy = "book")
    private List<UserBook> usersBook = new ArrayList<>();
    @OneToMany (cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "book")
    private List<Image> images = new ArrayList<>();

}
