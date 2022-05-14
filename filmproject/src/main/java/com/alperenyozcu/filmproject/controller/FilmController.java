package com.alperenyozcu.filmproject.controller;

import com.alperenyozcu.filmproject.model.Actors;
import com.alperenyozcu.filmproject.model.Film;
import com.alperenyozcu.filmproject.model.Languages;
import com.alperenyozcu.filmproject.repository.ActorRepository;
import com.alperenyozcu.filmproject.repository.FilmRepository;
import com.alperenyozcu.filmproject.repository.LanguageRepository;
import com.alperenyozcu.filmproject.service.FilmService;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping(value = "/Film",method = RequestMethod.GET)
public class FilmController {
    @Autowired
    FilmService filmService;
    @Autowired
    ActorRepository actorRepository;
    @Autowired
    LanguageRepository languageRepository;
    @Autowired
    FilmRepository filmRepository;

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
    @GetMapping({"/Films"})
    public ModelAndView home5(Model model) {
        List<Film> all = filmRepository.findAll();
        model.addAttribute("Film",all);
        return new ModelAndView("AdminFilms");

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
    public  RedirectView addfilm(@RequestParam String filmname, @RequestParam String production, @RequestParam String type,
                                        @RequestParam String actors, @RequestParam String languages, @RequestParam Date relased, @RequestParam String description)
    {
        Film film=new Film();
        film.setFilmname(filmname);
        film.setProduction(production);
        film.setType(type);
        film.setRelased(relased);
        film.setDescription(description);
        String[] strActorId = actors.split(",");
        String[] strLangId = languages.split(",");
        Boolean success = filmService.createFilm(film,strActorId,strLangId);
        Gson gson = new Gson();
        Map<String, Object> map = new HashMap<>();
        map.put("success", success);

        return new RedirectView("/Film/AddFilms");

    }
}
