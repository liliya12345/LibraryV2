package org.libraryv2.transformer;

import org.libraryv2.dto.UserDto;
import org.libraryv2.model.User;
import org.springframework.stereotype.Component;

@Component
public class TransformerUserToUserDto {
    public UserDto transform(User user) {
        UserDto userDtro = new UserDto();
        userDtro.setId(user.getId());
        userDtro.setFirstName(user.getFirstName());
        userDtro.setLastName(user.getLastName());
        userDtro.setBirthday(user.getBirthday());
        userDtro.setLogin(user.getLogin());
        return userDtro;


    }
}
