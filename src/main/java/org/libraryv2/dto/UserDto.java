package org.libraryv2.dto;

import lombok.Data;
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
