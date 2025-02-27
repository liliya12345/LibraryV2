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
    public String allBooks(Model model, Long id,Principal principal,String search) {
        model.addAttribute("categories", categoryService.findAll());
        model.addAttribute("authors", authorService.getAllAuthors());
        model.addAttribute("books", bookService.findAllDto());
        model.addAttribute("size", bookService.findAllDto().size());
        return "main";
    }

    @GetMapping("/books/{categoryId}")
    public String hello(@PathVariable Long categoryId, Long userId, Model model) {
        model.addAttribute("categories", categoryService.findAll());
        model.addAttribute("authors", authorService.getAllAuthors());
        model.addAttribute("info", userBooksService.findByUserId(userId));
        model.addAttribute("books", bookService.findAllDtoByCategoryId(categoryId));
        model.addAttribute("size", bookService.findAllDto().size());
        return "main";
    }

    @GetMapping("/lan/{userId}")
    public String user1(@PathVariable Long userId, Model model) {
        model.addAttribute("categories", categoryService.findAll());
        model.addAttribute("info", userBooksService.findByUserId(userId));
        return "user";
    }
    @GetMapping("/lan")
    public String user(Model model,Principal principal) {
        User userDetails = (User) ((UsernamePasswordAuthenticationToken) principal).getPrincipal();
        Long userId = userDetails.getId();
        model.addAttribute("user", userDetails);
        model.addAttribute("categories", categoryService.findAll());
        model.addAttribute("info", userBooksService.findByUserId(userId));
        return "user";
    }
    @GetMapping("/return_book/{userId}/{bookId}")
    public String returnBook(@PathVariable Long userId, @PathVariable Long bookId, Model model,Principal principal) {
        User userDetails = (User) ((UsernamePasswordAuthenticationToken) principal).getPrincipal();
        model.addAttribute("user", userDetails);
        userBooksService.addNewUserBook(userId,bookId);
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
        model.addAttribute("user", userDetails);
        model.addAttribute("categories", categoryService.findAll());
        model.addAttribute("info", userBooksService.findByUserId(userId));
        return "user";
    }

    @GetMapping("/lan/{userId}/{bookId}")
    public String lan(@PathVariable Long bookId, @PathVariable Long userId, Model model, Long categoryId) {
        userBooksService.updateDateOfReturn(bookId);
        model.addAttribute("categories", categoryService.findAll());
        model.addAttribute("info", userBooksService.findByUserId(userId));
//

        return "user";
    }

    @GetMapping("/add/{userId}/{bookId}")
    public String add(@PathVariable Long userId, @PathVariable Long bookId, Model model, Long categoryId) {
        model.addAttribute("categories", categoryService.findAll());
        model.addAttribute("info", userBooksService.findByUserId(userId));

        return "user";
    }
    @GetMapping("/logout")
    public String logout( Model model) {
        model.addAttribute("categories", categoryService.findAll());
        model.addAttribute("authors", authorService.getAllAuthors());
        model.addAttribute("books", bookService.findAllDto());
        model.addAttribute("size", bookService.findAllDto().size());

        return "main";
    }


}

