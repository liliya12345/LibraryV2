package org.libraryv2.controller;

import lombok.RequiredArgsConstructor;
import org.libraryv2.dto.BookDto;
import org.libraryv2.model.Author;
import org.libraryv2.model.Book;
import org.libraryv2.model.Category;
import org.libraryv2.service.AuthorService;
import org.libraryv2.service.BookService;
import org.libraryv2.service.CategoryService;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Controller
@RequiredArgsConstructor
@PreAuthorize("hasAuthority('ROLE_ADMIN')")
public class AdminController {
    private final CategoryService categoryService;
    private  final AuthorService authorService;
    private final BookService bookService;

    @GetMapping("/admin")
    public String admin(Model model) {
        model.addAttribute("categories", categoryService.findAll());
        model.addAttribute("authors",authorService.getAllAuthors());
       return "admin";
    }

    @PostMapping("/admin/add_category")
    public String addCategory(Category category) {
       categoryService.save(category);
       return "admin";
    }
    @PostMapping("/admin/add_author")
    public String addAuthor(Author author) {
        authorService.addNewAuthor(author);
        return "admin";
    }
    @PostMapping("/admin/add_book")
    public String addBook(@RequestParam MultipartFile file, BookDto book) throws IOException {
    bookService.addBook(book,file);
        return "redirect:/admin";
    }



}
