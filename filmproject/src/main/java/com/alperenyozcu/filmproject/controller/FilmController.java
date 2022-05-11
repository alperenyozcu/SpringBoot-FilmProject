package com.alperenyozcu.filmproject.controller;

import com.alperenyozcu.filmproject.model.Actors;
import com.alperenyozcu.filmproject.model.Languages;
import com.alperenyozcu.filmproject.model.User;
import com.alperenyozcu.filmproject.repository.ActorRepository;
import com.alperenyozcu.filmproject.repository.LanguageRepository;
import com.alperenyozcu.filmproject.service.FilmService;
import org.apache.tomcat.util.net.openssl.ciphers.Authentication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import com.alperenyozcu.filmproject.model.Film;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import java.util.List;

@Controller
@RequestMapping(value = "/Film",method = RequestMethod.GET)
public class FilmController {
    @Autowired
    FilmService filmService;
    @Autowired
    ActorRepository actorRepository;
    @Autowired
    LanguageRepository languageRepository;

    @GetMapping({"/AddFilms"})
    public ModelAndView home1(Model model) {

        List<Actors> all = actorRepository.findAll();
        List<Languages> all1 = languageRepository.findAll();
        model.addAttribute("Actors",all);

        model.addAttribute("Languages",all1);
        return new ModelAndView("AddFilm");

    }
    @GetMapping({"/AddActors"})
    public ModelAndView home2(Model model) {

        return new ModelAndView("AddActors");

    }
    @GetMapping({"/AddLang"})
    public  ModelAndView home4(Model model)
    {

        return new ModelAndView("AddLanguages");
    }
    @PostMapping("AddAct")
    public RedirectView addAct(@ModelAttribute Actors actors)
    {
        filmService.createAct(actors);
        return new RedirectView("/Film/AddActors");
    }
    @PostMapping("SaveLang")
    public RedirectView addAct(@ModelAttribute Languages languages)
    {
        filmService.createLang(languages);
        return new RedirectView("/Film/AddLang");
    }

    @PostMapping("/Add")// film kayıt
    public String addfilm(@ModelAttribute Film film)
    {
        filmService.createFilm(film);
        return "/admin/homepage";

    }
}
