package com.example.HomeUser.controller;

import com.example.HomeUser.model.Question;
import com.example.HomeUser.service.QuestionService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin
@RestController
public class QuestionController {
    @Autowired
    QuestionService questionService;
    @Autowired
    ObjectMapper objectMapper;

    @GetMapping("/questions")
    public String getAllQuestion(){
        List<Question> allQuestion = questionService.getAllQuestion();
        try {
            return objectMapper.writeValueAsString(questionService.getAllQuestion());
        }catch (JsonProcessingException e){
            e.printStackTrace();
        }
        return String.valueOf(allQuestion);
    }
    @GetMapping("/question/{id}")
    public String getQuestion(@PathVariable long id){
        List<Question> allQuestionId = questionService.getAllQuestion();
        getQuestion(id);
        try{
            return objectMapper.writeValueAsString(questionService.getAllQuestion());
        }catch (JsonProcessingException e){
            e.printStackTrace();
        }
        return String.valueOf(allQuestionId);
    }

    @PostMapping("/newQuestion")
    public String newQuestion (@RequestBody String newQuestionJson){
        try {
            Question question = objectMapper.readValue(newQuestionJson, Question.class);
            questionService.saveQuestion(question);
        }catch (Exception e){
            return String.valueOf(HttpStatus.NOT_FOUND);
        }
        return String.valueOf(HttpStatus.OK);
    }

    @DeleteMapping("/question/{id}")
    public String deleteQuestion (@PathVariable Long id){
        boolean delete = questionService.delete(id);
        if(delete == true){
            return String.valueOf(HttpStatus.NOT_FOUND);
        }
        return String.valueOf(HttpStatus.OK);
    }
    @GetMapping("/drawquestions")
    public String drawQuestions(){
        Question drawQuestions = questionService.drawQuestions();
        try {
            return objectMapper.writeValueAsString(questionService.drawQuestions());
        }catch (JsonProcessingException e){
            e.printStackTrace();
        }
        return String.valueOf(drawQuestions());
    }
}
