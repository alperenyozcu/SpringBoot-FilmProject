package com.alperenyozcu.filmproject.service;


import com.alperenyozcu.filmproject.model.User;
import com.alperenyozcu.filmproject.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;
    public User findByMail(String mail) {
        return userRepository.findByemail(mail);

    }

    public void createUser(User user) {
        userRepository.save(user);
    }
}
