package org.libraryv2.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.libraryv2.model.Author;
import org.libraryv2.model.Category;
import org.libraryv2.model.Image;
import org.libraryv2.model.Language;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class BookDto {
    private Long id;
    private String title;
    private String description;
    private String publisher;
    private Integer year;
    private Language language;
    private Long author;
    private String authorFirstName;
    private String authorLastName;
    private Long category;
    private String categoryName;
}
