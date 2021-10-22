package com.example.myrepairmentagency.controller;

import com.example.myrepairmentagency.dto.UserDTO;
import com.example.myrepairmentagency.entity.User;
import com.example.myrepairmentagency.service.UserServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Slf4j
@RestController
@RequestMapping("/users")
public class UsersController {

    private final UserServiceImpl userService;

    @Autowired
    public UsersController(UserServiceImpl userService) {
        this.userService = userService;
    }

    @GetMapping("/new")
    public String newUser(Model model) {
        model.addAttribute("user", new User());
        return "users/new";
    }

    @PostMapping()
    public String create(@ModelAttribute("user") @Valid User user, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "users/new";
        } else {
            userService.createUser(user);
            return "index.html";
        }
    }

//    @GetMapping("/login")
//    public String newUser() {
//        return "users/login";
//    }
//
//    @ResponseStatus(HttpStatus.CREATED)
//    @PostMapping(value = "/login")
//    public void loginFormController(UserDTO user){
//        log.info("{}",userService.findUserByEmail(user));
//        log.info("{}", user);
//    }

//    @GetMapping("/login")
//    public String login(Model model) {
//        model.addAttribute("user", new User());
//        return "users/login-page";
//    }
//
//    @PostMapping("/login-page")
//    public String create(@ModelAttribute("user") @Valid User user, BindingResult bindingResult) {
//        if (bindingResult.hasErrors()) {
//            return "users/login";
//        } else {
//            usersRepository.save(user);
//            return "index.html";
//        }
//    }

}
