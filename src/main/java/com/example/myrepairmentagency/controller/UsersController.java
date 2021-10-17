package com.example.myrepairmentagency.controller;

import com.example.myrepairmentagency.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

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


//    @GetMapping("")
//    public String showBalance(Model model){
//        model.addAttribute("balance", usersRepository.findByEmail().);
//        return "users/home-page";
//    }
}
