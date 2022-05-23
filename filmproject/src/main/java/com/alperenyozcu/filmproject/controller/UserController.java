package com.alperenyozcu.filmproject.controller;

import com.alperenyozcu.filmproject.model.*;
import com.alperenyozcu.filmproject.repository.ActorRepository;
import com.alperenyozcu.filmproject.repository.CommentsRepository;
import com.alperenyozcu.filmproject.repository.FilmRepository;
import com.alperenyozcu.filmproject.repository.LanguageRepository;
import com.alperenyozcu.filmproject.service.CommentsService;
import com.alperenyozcu.filmproject.service.FilmService;
import com.alperenyozcu.filmproject.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import java.security.Principal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Base64;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService userservice;
    @Autowired
    FilmRepository filmRepository;
    @Autowired
    FilmService filmService;
    @Autowired
    ActorRepository actorRepository;
    @Autowired
    LanguageRepository languageRepository;
    @Autowired
    CommentsService commentsService;
    @Autowired
    CommentsRepository commentsRepository;


    //sql sorgusu ile filmler tarihe göre  sıralı çekilsin
    //arama özelliği olmalı
    // yorum yapma özelliği olmalı
    @GetMapping({"/homepage",""})
    public ModelAndView home(Principal principal, Model model) {
        List<Film> all = filmRepository.findAll();
        model.addAttribute("Film",all);
        User kullanici = userservice.findByMail(principal.getName());
        List<String> posters= new ArrayList<>();
        all.forEach(film -> {
            String base64= Base64.getEncoder().encodeToString(film.getPoster());
            posters.add(base64);
        });
        model.addAttribute("Posters",posters);
        model.addAttribute("kullanici", kullanici);
        return new ModelAndView("UserFilms");
    }

    @GetMapping("/Detay/{filmId}")
    public ModelAndView FilmDetay(@PathVariable("filmId") Integer filmId, Model model)
    {
        Film film=filmService.findById(filmId);
        List<Actors> all = actorRepository.findAll();
        List<Languages> all1 = languageRepository.findAll();
        List<Comments> filmComments= commentsRepository.findByFilmId(filmId);
        model.addAttribute("Comments",filmComments);
        model.addAttribute("Actors",all);
        model.addAttribute("Languages",all1);
        model.addAttribute("Film",film);
        String s = Base64.getEncoder().encodeToString(film.getPoster());
        model.addAttribute("poster",s);
        return new ModelAndView("UserFilmDetail");
    }

    @PostMapping("/AddComment/{filmId}")
    public RedirectView addComment(@PathVariable("filmId") Integer filmId, @RequestParam String Context, Authentication authentication)
    {

        SimpleDateFormat formatter= new SimpleDateFormat("yyyy-MM-dd 'at' HH:mm:ss z");
        Date date = new Date(System.currentTimeMillis());
        Comments comments=new Comments();
        comments.setContext(Context);
        comments.setCreationTime(date);
        Film filmbyid=filmService.findById(filmId);
        comments.setFilm(filmbyid);
        User currentUser = userservice.getCurrentUser(authentication);
        comments.setUser(currentUser);
        commentsService.createComment(comments);

        return  new RedirectView("/user/Detay/{filmId}");
    }


}
