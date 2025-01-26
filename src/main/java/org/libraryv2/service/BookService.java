package org.libraryv2.service;

import lombok.RequiredArgsConstructor;
import org.libraryv2.dto.BookDto;
import org.libraryv2.model.Author;
import org.libraryv2.model.Book;
import org.libraryv2.model.Image;
import org.libraryv2.repository.AuthorRepository;
import org.libraryv2.repository.BookRepository;
import org.libraryv2.transformer.TransformerBookDtoToBook;
import org.libraryv2.transformer.TrasformerBookToBookDto;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class BookService {
    private final BookRepository repository;
    private final TransformerBookDtoToBook transformerBookDtoToBook;
    private final TrasformerBookToBookDto trasformerBookToBookDto;
    private final BookRepository bookRepository;
    private final AuthorRepository authorRepository;

    public void save(Book book) {
        repository.save(book);
    }


    public List<Book> findAll() {
        return repository.findAll();
    }
    public List<BookDto> findAllDto() {
        return repository.findAll().stream().map(trasformerBookToBookDto::transform).limit(20).toList();
    }
    private Book findById(Long id) {
        return repository.findById(id).orElse(null);
    }
    public void addBook(BookDto bookDto, MultipartFile file) throws IOException {
        Book book = transformerBookDtoToBook.transform(bookDto);
        Image image = new Image();
        if(file.getSize()!=0) {
            image= convert(file);
        }
        image.setBook(book);
        List<Image> images = new ArrayList<>();
        images.add(image);
        book.setImages(images);
        repository.save(book);


    }
    private Image convert(MultipartFile multipartFile) throws IOException {
        Image image = new Image();
        image.setName(multipartFile.getName());
        image.setOriginalFileName(multipartFile.getOriginalFilename());
        image.setContentType(multipartFile.getContentType());
        image.setSize(multipartFile.getSize());
        image.setBytes(multipartFile.getBytes());
        return image;
    }

    public List<BookDto> findAllDtoByCategoryId(Long categoryId) {
      return  bookRepository.findAllByCategoryId(categoryId).stream().map(trasformerBookToBookDto::transform).toList();
    }

    public List<BookDto> search(String search) {
        List<Book> bookList = new ArrayList<>();
        List<Author> authors = authorRepository.findByLastNameOrFirstName(search,search);
        for (Author author : authors) {
            List<Book> listBooks = bookRepository.findAll().stream().filter(book -> book.getAuthor().contains(author)).toList();
            for (Book book : listBooks) {
                bookList.add(book);
            }
        }
        List<Book> books = bookRepository.findAll().stream().filter(book -> book.getTitle().equals(search)).toList();
        for (Book book : books) {
            bookList.add(book);
        }
        return  bookList.stream().map(trasformerBookToBookDto::transform).toList();
    }
}
