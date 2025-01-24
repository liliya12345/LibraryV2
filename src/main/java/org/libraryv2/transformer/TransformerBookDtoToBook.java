package org.libraryv2.transformer;

import lombok.RequiredArgsConstructor;
import org.libraryv2.dto.BookDto;
import org.libraryv2.model.Author;
import org.libraryv2.model.Book;
import org.libraryv2.model.Category;
import org.libraryv2.model.Language;
import org.libraryv2.repository.AuthorRepository;
import org.libraryv2.repository.CategoryRepository;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@Component
public class TransformerBookDtoToBook {
    private final AuthorRepository authorRepository;
    private final CategoryRepository categoryRepository;

    public Book transform(BookDto bookDto) {
        Book book = new Book();
        book.setId(bookDto.getId());
        book.setTitle(bookDto.getTitle());
        book.setDescription(bookDto.getDescription());
        book.setLanguage(Language.SWEDISH);
        Author author = authorRepository.findById(bookDto.getAuthor()).orElse(null);
        List<Author> authors = new ArrayList<>();
        authors.add(author);
        book.setAuthor(authors);
        Category category = categoryRepository.findById(bookDto.getCategory()).orElse(null);
        book.setCategory(category);
        return book;


    }
}
