package org.libraryv2.transformer;

import org.libraryv2.dto.UserBookDto;
import org.libraryv2.dto.UserDto;
import org.libraryv2.model.User;
import org.libraryv2.model.UserBook;
import org.libraryv2.repository.BookRepository;
import org.springframework.stereotype.Component;

@Component
public class TransformerUserBookToDto {

    public TransformerUserBookToDto(BookRepository bookRepository) {
    }

    public UserBookDto transform(UserBook userBook){
        UserBookDto userBookDto = new UserBookDto();
        userBookDto.setId(userBook.getId());
        userBookDto.setBookTitle(userBook.getBook().getTitle());
        userBookDto.setBookId(userBook.getBook().getId());
        userBookDto.setUser(userBook.getUser().getId());
        userBookDto.setDateOfLoan(userBook.getDateOfLoan());
        userBookDto.setDateOfReturn(userBook.getDateOfReturn());
        userBookDto.setReturned(userBook.isReturned());
        return userBookDto;
    }
}
