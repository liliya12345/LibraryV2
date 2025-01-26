package org.libraryv2.controller;

import lombok.RequiredArgsConstructor;
import org.libraryv2.dto.BookDto;
import org.libraryv2.service.AuthorService;
import org.libraryv2.service.BookService;
import org.libraryv2.service.CategoryService;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class BookController {

    private final BookService bookService;
    private final CategoryService categoryService;
    private final AuthorService authorService;

    @GetMapping("/search")
    public String search(String search,Model model) {
      List<BookDto> bookDtoList= bookService.search(search);

        model.addAttribute("booklist", bookService.search(search));
        model.addAttribute("categories", categoryService.findAll());
        model.addAttribute("authors", authorService.getAllAuthors());
        model.addAttribute("books", bookService.findAllDto());
        model.addAttribute("size", bookService.findAllDto().size());

        return "search";
    }
}
