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
            return "users/balance";
        }
    }

//    @GetMapping("/balance")
//    public String updateBalance(Model model, @RequestParam("balance") double balance, User user) {
//        model.addAttribute("balance", user.getBalance());
//        return "users/balance";
//    }

    @GetMapping("/balance")
    public String updateBalance(Model model, User user) {
        model.addAttribute("balance", user.getBalance());
        return "users/balance";
    }

//    @PostMapping("/users/balance")
//    public String updateBalance(User user) {
//        userService.putMoney(user, user.getBalance());
//        return "index.html";
//    }

    @GetMapping("/login")
    public String getLogin() {
        return "users/login";
    }
//
//    @PostMapping("/login/{id}")
//    public String login(@RequestParam(value = "error", required = false) String error,
//                        @RequestParam(value = "logout", required = false) String logout,
//                        @PathVariable("id") Long id,
//                           Model model) {
//        model.addAttribute("error", error != null);
//        model.addAttribute("logout", logout != null);
//        model.addAttribute("user", userService.findByUserId(id));
//        return "users/balance";
//    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(value = "/login")
    public String loginFormController(UserDTO user){
        userService.findByUserLogin(user);
        log.info("{}",userService.findByUserLogin(user));
        log.info("{}", user);
        return "index";
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
