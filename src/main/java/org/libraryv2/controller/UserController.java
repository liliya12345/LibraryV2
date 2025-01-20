package org.libraryv2.controller;

import org.libraryv2.dto.UserDto;
import org.libraryv2.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.time.LocalDate;


@Controller
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }


    @GetMapping("/login")
    public String login() {

        return "login";
    }
    @GetMapping("/registration")
    public String formRegistration(Model model) {
        model.addAttribute("userDTO", new UserDto());
        return "registration";
    }

    @PostMapping("/registration")
    public String save(UserDto userDto, Model model) {

        userDto.setCreateDate(LocalDate.now());
            userService.create(userDto);
            model.addAttribute("userDTO", userDto);
        return "registration";
    }

    }


