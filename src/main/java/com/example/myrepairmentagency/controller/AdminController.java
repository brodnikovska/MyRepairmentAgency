package com.example.myrepairmentagency.controller;

import com.example.myrepairmentagency.dto.UserDTO;
import com.example.myrepairmentagency.entity.User;
import com.example.myrepairmentagency.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
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

    @GetMapping("/userslist/{id}")
    public ResponseEntity<User> show(@PathVariable("id") Long id, Model model) {
        //model.addAttribute("user", userService.findByUserId(id));
        User user = userService.findUserById(id);
        if (null == user) {
            return new ResponseEntity<>(user, HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(user, HttpStatus.OK);
//        User user = userService.findByUserId(id)
//        UserDTO userDTO = userService.findByUserId();
//        return userService.findByUserId(id);
//        //return "users/show.html";
    }

}
