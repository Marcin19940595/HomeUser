package com.example.HomeUser.controller;

import com.example.HomeUser.model.Score;
import com.example.HomeUser.service.ScoreService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ScoreController {
    @Autowired
    ScoreService scoreService;
    @Autowired
    ObjectMapper objectMapper;

    @GetMapping("/score")
    public String getAllScore() {
        List<Score> allscore = scoreService.getAllScore();
        try {
            return objectMapper.writeValueAsString(scoreService.getAllScore());
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return String.valueOf(allscore);
    }
    @GetMapping("/score/{id}")
    public String getscore(@PathVariable long id){
        List<Score> getonescore = scoreService.getAllScore();
        getscore(id);
        try{
            return objectMapper.writeValueAsString(scoreService.getAllScore());
        } catch (Exception e) {
            e.printStackTrace();
        }return String.valueOf(getonescore);
    }
}