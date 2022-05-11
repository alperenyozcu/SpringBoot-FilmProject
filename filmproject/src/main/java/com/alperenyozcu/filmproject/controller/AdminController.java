package com.alperenyozcu.filmproject.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.security.Principal;

@Controller
@RequestMapping("/admin")
public class AdminController {

    @GetMapping({"/homepage",""})
    public ModelAndView home(Principal principal, Model model) {

        return new ModelAndView("AdminLayout");
    }
}
