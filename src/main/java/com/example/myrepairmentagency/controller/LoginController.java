package com.example.myrepairmentagency.controller;

import com.example.myrepairmentagency.dto.UserDTO;
import com.example.myrepairmentagency.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Slf4j
@Controller
@RequestMapping("/login")
public class LoginController {

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
    public String login(@RequestParam(value = "error", required = false) String error,
                        @RequestParam(value = "logout", required = false) String logout,
                        @RequestParam(value ="id") Long id,
                        Model model) {
        model.addAttribute("error", error != null);
        model.addAttribute("logout", logout != null);
        model.addAttribute("user", userService.findByUserId(id));
        log.info("User logged in" + userService.findByUserId(id));
        return "users/balance";
    }

//    @ResponseStatus(HttpStatus.CREATED)
//    @PostMapping(value = "login")
//    public void loginFormController(UserDTO user){
//        log.info("{}",userService.findByUserLogin(user));
//        log.info("{}", user);
///*       userService.saveNewUser(User.builder()
//                .firstName("Ann")
//                .lastName("Reizer")
//                .email("AnnReizer@testing.ua")
//                .role(RoleType.ROLE_USER)
//                .build());*/
//    }


}
