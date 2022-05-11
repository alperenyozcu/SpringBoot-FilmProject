package com.alperenyozcu.filmproject.controller;

import com.alperenyozcu.filmproject.model.User;
import com.alperenyozcu.filmproject.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


@Controller
@RequestMapping(value = "/register",method = RequestMethod.GET)
public class RegisterController {


    @Autowired
    UserService userService;

    @GetMapping({"/", ""})
    private  String registerPage()
    {
        return "register";
    }

    @PostMapping({"/registered"})
    public String register(@ModelAttribute User user) {
        user.setRole("USER");
        user.setPassword(new BCryptPasswordEncoder().encode(user.getPassword()));
        userService.createUser(user);
        return "login";
    }



}
