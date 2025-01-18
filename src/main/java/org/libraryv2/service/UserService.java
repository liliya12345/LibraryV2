package org.libraryv2.service;

import org.libraryv2.dto.UserDto;
import org.libraryv2.model.User;
import org.libraryv2.model.UserRole;
import org.libraryv2.repository.UserRepository;
import org.libraryv2.repository.UserRoleRepository;
import org.libraryv2.transformer.TransformerUserDTOToUser;
import org.springframework.context.annotation.Scope;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Optional;
@Service
public class UserService {
    private final UserRepository userRepository;
    private final UserRoleRepository userRoleRepository;
    private final PasswordEncoder passwordEncoder;
    private  final TransformerUserDTOToUser transformerUserDTOToUser;

    public UserService(UserRepository userRepository, UserRoleRepository userRoleRepository, PasswordEncoder passwordEncoder, TransformerUserDTOToUser transformerUserDTOToUser) {
        this.userRepository = userRepository;
        this.userRoleRepository = userRoleRepository;
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
        user.setUserRole(new UserRole(null,"USER_ROLE",null));
        User save = userRepository.save(user);
        return true;
    }
}
