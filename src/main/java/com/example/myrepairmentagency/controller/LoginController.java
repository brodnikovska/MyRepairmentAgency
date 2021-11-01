package com.example.myrepairmentagency.controller;

import com.example.myrepairmentagency.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class LoginController {

    private final UserService userService;

    @Autowired
    public LoginController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/login")
    public String loginPage(){
        return "login.html";
    }

    @PostMapping("/login/{id}")
    public String login(@RequestParam(value = "error", required = false) String error,
                        @RequestParam(value = "logout", required = false) String logout,
                        @PathVariable("id") Long id,
                        Model model) {
        model.addAttribute("error", error != null);
        model.addAttribute("logout", logout != null);
        model.addAttribute("user", userService.findByUserId(id));
        return "You have successfully logged in";
    }
}
