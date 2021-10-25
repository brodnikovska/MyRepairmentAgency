package com.example.myrepairmentagency.controller;

import com.example.myrepairmentagency.dto.UserDTO;
import com.example.myrepairmentagency.entity.RoleType;
import com.example.myrepairmentagency.entity.User;
import com.example.myrepairmentagency.repository.UsersRepository;
import com.example.myrepairmentagency.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Slf4j
@Controller
@RequestMapping("/users")
public class UsersController {

    private final UserService userService;

    @Autowired
    public UsersController(UserService userService) {
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
            userService.saveNewUser(user);
            return "index.html";
        }
    }

    @GetMapping("/balance")
    public String updateBalance(Model model) {
        model.addAttribute("user", new User());
        return "users/balance";
    }

//    @PatchMapping("/{id}")
//    public String updateBalance(@ModelAttribute("user") User user, @PathVariable("id") Long id) {
//        userService.
//    }

    @GetMapping("/login")
    public String newUser() {
        return "users/login";
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(value = "/login")
    public void loginFormController(UserDTO user){
        log.info("{}",userService.findByUserLogin(user));
        log.info("{}", user);
    }

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
