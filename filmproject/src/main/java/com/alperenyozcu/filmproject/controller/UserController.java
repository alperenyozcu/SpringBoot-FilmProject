package com.alperenyozcu.filmproject.controller;

import com.alperenyozcu.filmproject.model.User;
import com.alperenyozcu.filmproject.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.security.Principal;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService userservice;
    @GetMapping({"/homepage",""})
    public ModelAndView home(Principal principal, Model model) {
        User kullanici = userservice.findByMail(principal.getName());
        model.addAttribute("kullanici", kullanici);
        return new ModelAndView("homepage");
    }

}
