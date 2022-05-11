package com.alperenyozcu.filmproject.repository;

import com.alperenyozcu.filmproject.model.Languages;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LanguageRepository extends JpaRepository<Languages,Integer> {
}
