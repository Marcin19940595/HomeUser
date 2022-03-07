package com.example.HomeUser.model;

import org.springframework.stereotype.Component;

import javax.persistence.*;

@Component
@Entity
@Table(name = "questions")
public class Question {
    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String question;
    private String odpA;
    private String odpB;


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
    public Question() {
    }

    public Question(String question, String odpA,String odpB) {
        this.question = question;
        this.odpA = odpA;
        this.odpB = odpB;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getOdpA() {
        return odpA;
    }

    public void setOdpA(String odpA) {
        this.odpA = odpA;
    }

    public String getOdpB() {
        return odpB;
    }

    public void setOdpB(String odpC) {
        this.odpB = odpC;
    }

}
