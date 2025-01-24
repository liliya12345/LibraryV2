package org.libraryv2.dto;

import lombok.*;
import org.libraryv2.model.Book;

import javax.persistence.*;
import java.util.List;

@Data
public class AuthorDto {

    private Long id;
    private String firstName;
    private String lastName;


}
