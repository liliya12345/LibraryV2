package org.libraryv2.service;

import lombok.RequiredArgsConstructor;
import org.libraryv2.dto.BookDto;
import org.libraryv2.dto.UserBookDto;
import org.libraryv2.model.Book;
import org.libraryv2.model.User;
import org.libraryv2.model.UserBook;
import org.libraryv2.repository.BookRepository;
import org.libraryv2.repository.UserBookRepository;
import org.libraryv2.repository.UserRepository;
import org.libraryv2.transformer.TransformerUserBookToDto;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserBooksService {
    private final UserBookRepository userBookRepository;
    private final TransformerUserBookToDto transformerUserBookToDto;
    private final BookRepository bookRepository;
    private final BookService bookService;
    private final UserRepository userRepository;

    public List<UserBookDto> findByUserId(@PathVariable Long userId) {
        return userBookRepository.findByUserId(userId).stream().map(transformerUserBookToDto::transform).toList();

    }

    public UserBookDto updateDateOfReturn(@PathVariable Long bookId) {
        UserBook userBook = userBookRepository.findById(bookId).orElse(null);
        if (userBook != null) {
            LocalDate localDate = userBook.getDateOfReturn().plusDays(30);
            userBook.setDateOfReturn(localDate);
        }
        assert userBook != null;
        return transformerUserBookToDto.transform(userBookRepository.save(userBook));
//          transformerUserBookToDto.transform(userBook);

    }


    public UserBook addNewUserBook(@PathVariable Long userId, @PathVariable Long bookId) {
        UserBook usersBook = new UserBook();
        Optional<User> optionalUser = userRepository.findById(userId);
        Optional<Book> optionalBook = bookRepository.findById(bookId);
        if (optionalUser.isPresent() && optionalBook.isPresent()) {
            usersBook.setUser(optionalUser.get());
            usersBook.setBook(optionalBook.get());
            usersBook.setDateOfLoan(LocalDate.now());
            usersBook.setDateOfReturn(LocalDate.now().plusDays(30));
            usersBook.setReturned(false);
            userBookRepository.save(usersBook);
        }
        return usersBook;
    }

    public void returnBook(Long userId, Long bookId) {
        List<UserBook> byUserId = userBookRepository.findByUserId(userId);
        Optional<UserBook> first = byUserId.stream().filter(u -> u.getId().equals(bookId)).findFirst();
//        Optional<UserBook> first = byUserId.stream().filter(u -> u.getBook().getId().equals(bookId)).findFirst();
        if (first.isPresent()) {
           UserBook userBook=  first.get();
           userBook.setReturned(true);
            userBookRepository.save(userBook);
        }
    }
}

