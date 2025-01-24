package org.libraryv2.controller;

import lombok.RequiredArgsConstructor;
import org.libraryv2.model.User;
import org.libraryv2.repository.ImageRepository;
import org.libraryv2.repository.UserBookRepository;
import org.libraryv2.service.*;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;


import java.security.Principal;
import java.util.List;

import static org.springframework.data.jpa.domain.AbstractPersistable_.id;

@Controller
@RequiredArgsConstructor
public class LibraryController {
    private final CategoryService categoryService;
    private final AuthorService authorService;
    private final BookService bookService;
    private final UserBooksService userBooksService;
    private final UserBookRepository userBookRepository;

    @GetMapping("/")
    public String allBooks(Model model, Long id) {
        model.addAttribute("categories", categoryService.findAll());
        model.addAttribute("authors", authorService.getAllAuthors());
//        model.addAttribute("books",bookService.findAll());
        model.addAttribute("books", bookService.findAllDto());
//        model.addAttribute("images",imageRepository.findAll());
        model.addAttribute("size", bookService.findAllDto().size());
        return "main";
    }

    @GetMapping("/books/{categoryId}")
    public String hello(@PathVariable Long categoryId, Long userId, Model model) {
        model.addAttribute("categories", categoryService.findAll());
        model.addAttribute("authors", authorService.getAllAuthors());
//        model.addAttribute("books",bookService.findAll());
        model.addAttribute("info", userBooksService.findByUserId(userId));
//        model.addAttribute("user",userBookRepository.findById(userId));
        model.addAttribute("books", bookService.findAllDtoByCategoryId(categoryId));
//        model.addAttribute("images",imageRepository.findAll());
        model.addAttribute("size", bookService.findAllDto().size());
//        model.addAttribute("userbook", userBookRepository.findByUserId(userId));
        return "main";
    }

    @GetMapping("/lan/{userId}")
    public String user(@PathVariable Long userId, Model model) {
        model.addAttribute("categories", categoryService.findAll());
        model.addAttribute("info", userBooksService.findByUserId(userId));
        return "user";
    }
    @GetMapping("/return_book/{userId}/{bookId}")
    public String returnBook(@PathVariable Long userId, @PathVariable Long bookId, Model model) {
        userBooksService.returnBook(userId,bookId);
        model.addAttribute("categories", categoryService.findAll());
        model.addAttribute("info", userBooksService.findByUserId(userId));
        return "user";
    }
    @GetMapping("/booking/{bookId}")
 public String booking(@PathVariable Long bookId, Model model, Principal principal) {
        User userDetails = (User) ((UsernamePasswordAuthenticationToken) principal).getPrincipal();
        Long userId = userDetails.getId();
        userBooksService.addNewUserBook(userId,bookId);
        model.addAttribute("categories", categoryService.findAll());
        model.addAttribute("info", userBooksService.findByUserId(userId));
        return "user";
    }

    @GetMapping("/lan/{userId}/{bookId}")
    public String lan(@PathVariable Long bookId, @PathVariable Long userId, Model model, Long categoryId) {
        userBooksService.updateDateOfReturn(bookId);
        model.addAttribute("categories", categoryService.findAll());
//        model.addAttribute("authors", authorService.getAllAuthors());
//        model.addAttribute("books", bookService.findAllDto());
        model.addAttribute("info", userBooksService.findByUserId(userId));
//        model.addAttribute("user", userBookRepository.findById(userId));
//        model.addAttribute("books", bookService.findAllDtoByCategoryId(categoryId));
//        model.addAttribute("changesdatebook", userBooksService.updateDateOfReturn(bookId));
//        model.addAttribute("users", userBookRepository.findAll());
//        model.addAttribute("images", imageRepository.findAll());
//        model.addAttribute("size", bookService.findAllDto().size());

        return "user";
    }

    @GetMapping("/add/{userId}/{bookId}")
    public String add(@PathVariable Long userId, @PathVariable Long bookId, Model model, Long categoryId) {
        model.addAttribute("categories", categoryService.findAll());
//        model.addAttribute("authors", authorService.getAllAuthors());
//        model.addAttribute("books", bookService.findAllDto());
//        model.addAttribute("books", bookService.findAllDtoByCategoryId(categoryId));
        model.addAttribute("info", userBooksService.findByUserId(userId));
//        model.addAttribute("user", userBookRepository.findById(userId));
//        model.addAttribute("books", bookService.findAllDto());
//        model.addAttribute("size", bookService.findAllDto().size());
//        model.addAttribute("changesdatebook", userBooksService.updateDateOfReturn(bookId));
//        model.addAttribute("users", userBookRepository.findAll());
//        model.addAttribute("images", imageRepository.findAll());
//         model.addAttribute("newuserbook",userBooksService.addNewUserBook(userId,bookId));

        return "user";
    }


}

