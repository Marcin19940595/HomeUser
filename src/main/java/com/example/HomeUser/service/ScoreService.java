package com.example.HomeUser.service;

import com.example.HomeUser.model.Score;
import com.example.HomeUser.repository.ScoreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ScoreService {
    @Autowired
    ScoreRepository scoreRepository;

    public List<Score> getAllScore(){
        return scoreRepository.findAll();
    }
}
