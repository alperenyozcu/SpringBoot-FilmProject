package com.alperenyozcu.filmproject.controller;

import com.alperenyozcu.filmproject.model.User;
import com.alperenyozcu.filmproject.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.view.RedirectView;

import java.security.Principal;

@Controller
public class MainController {
    @Autowired
    UserService userService;

    @GetMapping("/")
    public RedirectView redirect(Principal principal, Model model)
    {
        if(principal==null)
            return new RedirectView("login");

        User user = userService.findByMail(principal.getName());


        if(user.getRole().equals("USER"))
        {

            return new RedirectView("user/homepage");
        }

        return new RedirectView("/admin/homepage");

    }
}
