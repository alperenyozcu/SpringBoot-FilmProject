package com.alperenyozcu.filmproject.controller;
import com.alperenyozcu.filmproject.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class LoginController {

    @Autowired
    UserRepository userRepository;

    @GetMapping({"/login"})
    public String login() {
        return "login";
    }
}

