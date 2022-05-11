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

@Service
public class FilmService {

    @Autowired
    FilmRepository filmRepository;
    @Autowired
    ActorRepository actorRepository;
    @Autowired
    LanguageRepository languageRepository;

    public void createFilm(Film film) {
        filmRepository.save(film);
    }

    public void createAct(Actors actors) {
       actorRepository.save(actors);
    }

    public void createLang(Languages languages) {
        languageRepository.save(languages);
    }
}
