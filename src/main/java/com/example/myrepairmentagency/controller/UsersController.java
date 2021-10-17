package com.example.myrepairmentagency.controller;

import com.example.myrepairmentagency.entity.User;
import com.example.myrepairmentagency.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/users")
public class UsersController {

    private final UsersRepository usersRepository;

    @Autowired
    public UsersController(UsersRepository usersRepository) {
        this.usersRepository = usersRepository;
    }

    @GetMapping()
    public String index(Model model) {
       model.addAttribute("users", usersRepository.findAll());
       return "users/all.html";
    }

    @GetMapping("/{id}")
    public String show(@PathVariable("id") Long id, Model model) {
       model.addAttribute("user", usersRepository.findById(id));
       return "users/show.html";
    }

    @GetMapping("/new")
    public String newUser(Model model) {
        model.addAttribute("user", new User());
        return "users/new";
    }

//    @PostMapping()
//    public String create(@ModelAttribute("user") User user) {
//        usersRepository.save(user);
//        return "redirect:/users";
//    }

    @PostMapping()
    public String create(@RequestParam("firstName") String firstName, @RequestParam("lastName") String lastName,
                         @RequestParam("email") String email, @RequestParam("password") String password) {
        User user = new User(firstName, lastName, email, password);
        usersRepository.save(user);
        return "redirect:/users";
    }

}
