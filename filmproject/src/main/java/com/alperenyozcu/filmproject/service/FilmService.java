package com.alperenyozcu.filmproject.service;

import com.alperenyozcu.filmproject.model.Actors;
import com.alperenyozcu.filmproject.model.Film;
import com.alperenyozcu.filmproject.model.Languages;
import com.alperenyozcu.filmproject.model.User;
import com.alperenyozcu.filmproject.repository.ActorRepository;
import com.alperenyozcu.filmproject.repository.FilmRepository;
import com.alperenyozcu.filmproject.repository.LanguageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class FilmService {

    @Autowired
    FilmRepository filmRepository;
    @Autowired
    ActorRepository actorRepository;
    @Autowired
    LanguageRepository languageRepository;



    public void createAct(Actors actors) {
       actorRepository.save(actors);
    }

    public void createLang(Languages languages) {
        languageRepository.save(languages);
    }

    public Boolean createFilm(Film film, String[] strActorId, String[] strLangId) {

        try{

            List<Actors> actors=new ArrayList<>();
            List<Languages> languages=new ArrayList<>();
            for (String actorId:strActorId) {
             actors.add(actorRepository.findById(Integer.parseInt(actorId)).get());
            }
            for (String langId:strLangId) {
                languages.add(languageRepository.findById(Integer.parseInt(langId)).get());
            }
            film.setActors(actors);
            film.setLanguages(languages);
            filmRepository.save(film);
            return  true;
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
            return  false;
        }
    }
}
