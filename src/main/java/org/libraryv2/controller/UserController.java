package org.libraryv2.controller;

import org.libraryv2.dto.UserDto;
import org.libraryv2.model.User;
import org.libraryv2.service.CategoryService;
import org.libraryv2.service.UserBooksService;
import org.libraryv2.service.UserService;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.security.Principal;
import java.time.LocalDate;


@Controller
public class UserController {
    private final UserService userService;
  private final CategoryService categoryService;
  private final UserBooksService userBooksService;
    public UserController(UserService userService, CategoryService categoryService, UserBooksService userBooksService) {
        this.userService = userService;
        this.categoryService = categoryService;
        this.userBooksService = userBooksService;
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
    @GetMapping("/change_my_profile")
    public String changeMyProfile(Model model, Principal principal) {
        User userDetails = (User) ((UsernamePasswordAuthenticationToken) principal).getPrincipal();
        Long userId = userDetails.getId();
        model.addAttribute("user", userService.getUserById(userId));
        return "change_my_profile";

    }
    @PostMapping("/change_my_profile")
    public String changeMyProfileInfo(UserDto userDto,Model model,Principal principal) {
        User userDetails = (User) ((UsernamePasswordAuthenticationToken) principal).getPrincipal();
        Long userId = userDetails.getId();
        userDto.setId(userId);
        userService.changeUsersInfo(userDto);
        model.addAttribute("user", userService.getUserById(userId));
        model.addAttribute("categories", categoryService.findAll());
        model.addAttribute("info", userBooksService.findByUserId(userId));
       return "user";
    }

    }


