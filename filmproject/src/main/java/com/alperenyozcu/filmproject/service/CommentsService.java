package com.alperenyozcu.filmproject.service;

import com.alperenyozcu.filmproject.model.*;
import com.alperenyozcu.filmproject.repository.CommentsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CommentsService {

    @Autowired
    CommentsRepository commentsRepository;


    public void createComment(Comments comments) {commentsRepository.save(comments);
    }


}
