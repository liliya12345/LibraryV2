package org.libraryv2.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name="users_books")
public class UserBook {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne(cascade = CascadeType.ALL)
    private User user;
    @ManyToOne(cascade = CascadeType.ALL)
    private Book book;
    @Column (name="date_of_loans")
    private LocalDate dateOfLoan;
    @Column (name="date_of_return")
    private LocalDate dateOfReturn;


}
