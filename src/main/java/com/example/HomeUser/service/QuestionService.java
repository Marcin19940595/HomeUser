package com.example.HomeUser.service;

import com.example.HomeUser.model.Question;
import com.example.HomeUser.repository.QuestionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;

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
    public Question drawQuestions() {
        List<Question> getallquestions = getAllQuestion();
        Random random = new Random(getallquestions.size());
        return getallquestions.get(random.nextInt());
    }
}
