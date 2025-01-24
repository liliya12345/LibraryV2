package org.libraryv2.transformer;

import org.libraryv2.dto.AuthorDto;
import org.libraryv2.dto.CategoryDto;
import org.libraryv2.model.Author;
import org.libraryv2.model.Category;
import org.springframework.stereotype.Component;

@Component
public class TransformerAuthorToAuthorDto {

        public AuthorDto transform(Author author) {
            AuthorDto authorDto = new AuthorDto();
            authorDto.setId(author.getId());
            authorDto.setFirstName(author.getFirstName());
            authorDto.setLastName(author.getLastName());
            return authorDto;
        }

}
