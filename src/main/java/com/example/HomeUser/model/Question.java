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
    private String odpC;


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
    public Question() {
    }

    public Question(String question, String odpA, String odpC) {
        this.question = question;
        this.odpA = odpA;
        this.odpC = odpC;
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

    public String getOdpC() {
        return odpC;
    }

    public void setOdpC(String odpC) {
        this.odpC = odpC;
    }

    @Override
    public String toString() {
        return "Question{" +
                "id=" + id +
                ", question='" + question + '\'' +
                ", odpA='" + odpA + '\'' +
                ", odpC='" + odpC + '\'' +
                '}';
    }
}
