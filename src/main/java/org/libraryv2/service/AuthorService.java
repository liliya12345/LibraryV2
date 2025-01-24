package org.libraryv2.service;

import lombok.RequiredArgsConstructor;
import org.libraryv2.dto.AuthorDto;
import org.libraryv2.model.Author;
import org.libraryv2.repository.AuthorRepository;
import org.libraryv2.transformer.TransformerAuthorToAuthorDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AuthorService {
    private final AuthorRepository authorRepository;
    private final TransformerAuthorToAuthorDto transformerAuthorToAuthorDto;
    public void addNewAuthor(Author author) {
        authorRepository.save(author);
    }
    public List<AuthorDto> getAllAuthors() {
        return authorRepository.findAll().stream().map(transformerAuthorToAuthorDto::transform).toList();
    }
    public Author getAuthorById(long id) {
        return authorRepository.findById(id).orElse(null);
    }

}
