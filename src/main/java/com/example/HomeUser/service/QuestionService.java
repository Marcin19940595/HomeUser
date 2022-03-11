package com.example.HomeUser.service;

import com.example.HomeUser.model.Question;
import com.example.HomeUser.repository.QuestionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
public class QuestionService {
    @Autowired
    QuestionRepository questionRepository;

    public List<Question> getAllQuestion(){
        return questionRepository.findAll();
    }
    public void saveQuestion(Question question){
        questionRepository.save(question);
    }
    public boolean delete(Long id){
        questionRepository.deleteById(id);
        return Boolean.parseBoolean(null);
    }
    public String drawQuestions() {
        List<Question> getallquestions = questionRepository.findAll();
        Collections.shuffle(getallquestions);
        return String.valueOf(getallquestions);
    }
}
