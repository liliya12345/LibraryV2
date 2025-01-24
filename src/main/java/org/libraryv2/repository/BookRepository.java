package org.libraryv2.repository;

import org.libraryv2.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BookRepository  extends JpaRepository<Book, Long> {
    List<Book> findAllByCategoryId(Long id);


}
