package org.libraryv2.transformer;

import org.libraryv2.dto.BookDto;
import org.libraryv2.model.Book;
import org.springframework.stereotype.Component;

@Component
public class TrasformerBookToBookDto {
    public BookDto transform(Book book) {
        BookDto bookDto = new BookDto();
        bookDto.setId(book.getId());
        bookDto.setTitle(book.getTitle());
        bookDto.setDescription(book.getDescription());
        bookDto.setCategory(book.getCategory().getId());
        bookDto.setLanguage(book.getLanguage());
        bookDto.setYear(book.getYear());
        bookDto.setPublisher(book.getPublisher());
        if(book.getAuthor().size()>0){
            bookDto.setAuthorFirstName(book.getAuthor().get(0).getFirstName());
            bookDto.setAuthorLastName(book.getAuthor().get(0).getLastName());
            bookDto.setAuthor(book.getAuthor().get(0).getId());
        }
        else{
            bookDto.setAuthorFirstName("No name");
            bookDto.setAuthorLastName("No lasname");
            bookDto.setAuthor(1L);
        }

        return bookDto;

    }

}
