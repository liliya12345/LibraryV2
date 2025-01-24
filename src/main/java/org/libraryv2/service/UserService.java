package org.libraryv2.service;

import org.libraryv2.dto.UserDto;
import org.libraryv2.model.User;
import org.libraryv2.model.UserRole;
import org.libraryv2.repository.UserRepository;
import org.libraryv2.transformer.TransformerUserDTOToUser;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class UserService {
    private final UserRepository userRepository;

    private final PasswordEncoder passwordEncoder;
    private  final TransformerUserDTOToUser transformerUserDTOToUser;

    public UserService(UserRepository userRepository, PasswordEncoder passwordEncoder, TransformerUserDTOToUser transformerUserDTOToUser) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.transformerUserDTOToUser = transformerUserDTOToUser;
    }


    public Boolean create(UserDto userDTO) {
        User user = transformerUserDTOToUser.transform(userDTO);
        if (userRepository.findByLogin(user.getLogin()) != null) {
            return false;
        }
//        Optional<UserRole> roleUserFromDB = userRoleRepository.findByRole("ROLE_USER");
//        UserRole userRole;
//        if (roleUserFromDB.isPresent()) {
//            userRole = roleUserFromDB.get();
//        } else {
//            userRole = userRoleRepository.save(new UserRole(null, "ROLE_USER", null));
//        }
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setCreateDate(LocalDate.now());
        user.getUserRoles().add(UserRole.ROLE_USER);
        User save = userRepository.save(user);
        return true;
    }
}
