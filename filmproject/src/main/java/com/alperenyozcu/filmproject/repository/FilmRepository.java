package com.alperenyozcu.filmproject.repository;

import com.alperenyozcu.filmproject.model.Film;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface FilmRepository  extends JpaRepository<Film,Integer> {



}
