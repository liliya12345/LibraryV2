package org.libraryv2.dto;

import lombok.Data;
import org.libraryv2.model.Book;
import org.libraryv2.model.User;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.ManyToOne;
import java.time.LocalDate;

@Data
public class UserBookDto {
    private Long id;
    private Long user;
    private Long book;
    private String bookTitle;
    private Long bookId;
    private String authorFirstName;
    private String authorLastName;
    private LocalDate dateOfLoan;
    private LocalDate dateOfReturn;
    private Boolean returned;
}
