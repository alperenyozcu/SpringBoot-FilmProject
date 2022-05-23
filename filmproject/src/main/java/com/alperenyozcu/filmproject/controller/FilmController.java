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
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import java.util.*;

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
        List<String> posters= new ArrayList<>();
        all.forEach(film -> {
            String base64= Base64.getEncoder().encodeToString(film.getPoster());
            posters.add(base64);
        });
        model.addAttribute("Film",all);
        model.addAttribute("Posters",posters);
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
                                 @RequestParam String actors, @RequestParam String languages,
                                 @RequestParam Date relased, @RequestParam String description
            ,@RequestParam("poster") MultipartFile poster)
    {
        Film film=new Film();
        film.setFilmname(filmname);
        film.setProduction(production);
        film.setType(type);
        film.setRelased(relased);
        film.setDescription(description);
        try
        {
            film.setPoster(poster.getBytes());
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
        }
        String[] strActorId = actors.split(",");
        String[] strLangId = languages.split(",");
        Boolean success = filmService.createFilm(film,strActorId,strLangId);
        Gson gson = new Gson();
        Map<String, Object> map = new HashMap<>();
        map.put("success", success);

        return new RedirectView("/Film/AddFilms");

    }
    @GetMapping("/Detay/{filmId}")
    public ModelAndView FilmDetay(@PathVariable("filmId") Integer filmId,Model model)
    {
        Film film=filmService.findById(filmId);
        List<Actors> all = actorRepository.findAll();
        List<Languages> all1 = languageRepository.findAll();
        model.addAttribute("Actors",all);
        model.addAttribute("Languages",all1);
        model.addAttribute(film);
       return new ModelAndView("FilmDetail");
    }
    @PostMapping ("/Update")
    public  RedirectView updateFilm (@ModelAttribute Film film)
    {
        filmRepository.save(film);
       return  new RedirectView("/Film/Films");
    }
    @GetMapping("/Delete/{filmId}")
    public RedirectView DeleteFilm (@PathVariable("filmId") Integer filmId) {
        filmRepository.deleteById(filmId);
        return new RedirectView("/Film/Films");
    }
    @GetMapping("/Search")
    public ModelAndView SearchFilm(@RequestParam String searchParam,Model model)
    {

       List<Film> searchFilm= filmRepository.Search(searchParam.isBlank() || searchParam.isEmpty() ? null : searchParam);
        List<String> posters= new ArrayList<>();
        searchFilm.forEach(film -> {
            String base64= Base64.getEncoder().encodeToString(film.getPoster());
            posters.add(base64);
        });

        model.addAttribute("Posters",posters);
        model.addAttribute("Film",searchFilm);
        return  new ModelAndView("AdminFilms");
    }
}
