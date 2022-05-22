package com.alperenyozcu.filmproject.repository;

import com.alperenyozcu.filmproject.model.Comments;
import com.alperenyozcu.filmproject.model.Film;
import com.alperenyozcu.filmproject.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CommentsRepository extends JpaRepository<Comments, Integer> {


    @Query(value = "SELECT * FROM comments u WHERE u.filmid = :filmid ",
            nativeQuery = true)
    List<Comments> findByFilmId(
            @Param("filmid") Integer filmid);
}
