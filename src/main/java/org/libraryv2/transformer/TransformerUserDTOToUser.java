package org.libraryv2.transformer;


import org.libraryv2.dto.UserDto;
import org.libraryv2.model.User;
import org.springframework.stereotype.Component;

@Component
public class TransformerUserDTOToUser {
    public User transform(UserDto userDTO) {
        User user = new User();
        user.setId(userDTO.getId());
        user.setFirstName(userDTO.getFirstName());
        user.setLastName(userDTO.getLastName());
        user.setLogin(userDTO.getLogin());
        user.setPassword(userDTO.getPassword());
        user.setBirthday(userDTO.getBirthday());
        return  user;
    }
}
