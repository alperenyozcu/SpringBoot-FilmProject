package com.alperenyozcu.filmproject.repository;

import com.alperenyozcu.filmproject.model.Film;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FilmRepository  extends JpaRepository<Film,Integer> {
    @Query(value =" SELECT * FROM film f " +
            "join film_actors fa on fa.film_filmid = f.filmid " +
            "join actors a on a.actorid = fa.actors_actorid " +
            "where ( :searchParam is null or f.filmname=:searchParam ) " +
            " or (:searchParam is null or  f.type=:searchParam) " +
            " or (:searchParam is null or (a.actorname like concat('%', :searchParam, '%')) ) " +
            " group  by f.filmid ORDER BY relased DESC ",
            nativeQuery = true)
    List<Film> Search(String searchParam);

    @Query(value="SELECT poster from film ",nativeQuery = true)
    List<Film> poster();
}
