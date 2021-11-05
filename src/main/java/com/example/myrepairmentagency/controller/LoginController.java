package com.example.myrepairmentagency.controller;

import com.example.myrepairmentagency.dto.UserDTO;
import com.example.myrepairmentagency.entity.User;
import com.example.myrepairmentagency.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Slf4j
@Controller
@RequestMapping("/login")
public class LoginController {

    private static final Logger logger = LoggerFactory.getLogger(LoginController.class);

    private final UserService userService;

    @Autowired
    public LoginController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping()
    public String loginPage(){
        return "login.html";
    }

    @PostMapping()
    public String login(
                        @RequestParam(value ="username") String username,
                        @RequestParam(value ="password") String password,
                        Model model) {

        logger.info("Inside Login User");

//        model.addAttribute("error", error != null);
//        model.addAttribute("logout", logout != null);
//        model.addAttribute("user", userService.findByUserId(id));
//        log.info("User logged in" + userService.findByUserId(id));
        return "users/balance";
    }


}
