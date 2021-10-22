package com.example.myrepairmentagency.controller;

import com.example.myrepairmentagency.dto.UserDTO;
import com.example.myrepairmentagency.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin-panel")
public class AdminController {

    private UserServiceImpl userService;

    @Autowired
    public AdminController(UserServiceImpl userService) {
        this.userService = userService;
    }

    @GetMapping("")
    public String adminPage(){
        return "admin/home-page.html";
    }

    @GetMapping("/userslist")
    public String index(Model model) {
        model.addAttribute("users", userService.getAllUsers());
        return "users/all";
    }

//    @GetMapping("/userslist/{id}")
//    public String show(@PathVariable("id") Long id, Model model) {
//        //model.addAttribute("user", userService.findByUserId(id));
//        User user = userService.findByUserId(id)
//        UserDTO userDTO = userService.findByUserId();
//        return userService.findByUserId(id);
//        //return "users/show.html";
//    }

}
