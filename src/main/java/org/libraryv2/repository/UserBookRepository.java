package org.libraryv2.repository;

import org.libraryv2.dto.UserBookDto;
import org.libraryv2.model.UserBook;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserBookRepository extends JpaRepository<UserBook, Long> {
    List<UserBook> findByUserId(Long userId);

   UserBook findAllById(Long bookId);

}
