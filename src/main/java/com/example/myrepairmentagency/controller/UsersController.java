package com.example.myrepairmentagency.controller;

import com.example.myrepairmentagency.entity.RoleType;
import com.example.myrepairmentagency.entity.User;
import com.example.myrepairmentagency.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
@RequestMapping("/users")
public class UsersController {

    private final UsersRepository usersRepository;

    @Autowired
    public UsersController(UsersRepository usersRepository) {
        this.usersRepository = usersRepository;
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
            usersRepository.save(user);
            return "index.html";
        }
    }

//    @PostMapping()
//    public String create(@RequestParam("firstName") @Valid String firstName, BindingResult bindingResultName,
//                         @RequestParam("lastName") @Valid String lastName, BindingResult bindingResultSurname,
//                         @RequestParam("email") @Valid String email, BindingResult bindingResultEmail,
//                         @RequestParam("password") String password) {
//        User user = new User(firstName, lastName, email, password);
//        if (bindingResultName.hasErrors() || bindingResultSurname.hasErrors() || bindingResultEmail.hasErrors()) {
//            return "/users/new";
//        } else {
//            usersRepository.save(user);
//            return "index.html";
//        }
//    }

}
