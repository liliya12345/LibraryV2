package org.libraryv2.repository;

import org.libraryv2.model.Author;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AuthorRepository extends JpaRepository<Author, Long> {

    List<Author> findByLastNameOrFirstName(String lastName, String firstName);
}
