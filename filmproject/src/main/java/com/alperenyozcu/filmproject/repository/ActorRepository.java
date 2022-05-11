package com.alperenyozcu.filmproject.repository;

import com.alperenyozcu.filmproject.model.Actors;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ActorRepository extends JpaRepository<Actors,Integer> {
}
