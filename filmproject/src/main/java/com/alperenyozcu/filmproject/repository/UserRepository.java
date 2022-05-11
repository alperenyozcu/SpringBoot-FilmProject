package com.alperenyozcu.filmproject.repository;

import com.alperenyozcu.filmproject.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User,Integer> {

    User findByemail(String email);

}
