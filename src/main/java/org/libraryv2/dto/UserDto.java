package org.libraryv2.dto;

import lombok.Data;
import org.libraryv2.model.UserRole;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.ManyToOne;
import java.time.LocalDate;
@Data
public class UserDto {
    private Long id;
    private String firstName;
    private String lastName;
    private String login;
    private String password;
    private LocalDate birthday;
    private LocalDate createDate;
    private String userRole;
}
