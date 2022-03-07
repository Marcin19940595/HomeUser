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
    private String odbB;
    private String odpC;
    private String odpD;


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
    public Question() {
    }

    public Question(long id, String question, String odpA, String odbB, String odpC, String odpD) {
        this.id = id;
        this.question = question;
        this.odpA = odpA;
        this.odbB = odbB;
        this.odpC = odpC;
        this.odpD = odpD;
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

    public String getOdbB() {
        return odbB;
    }

    public void setOdbB(String odbB) {
        this.odbB = odbB;
    }

    public String getOdpC() {
        return odpC;
    }

    public void setOdpC(String odpC) {
        this.odpC = odpC;
    }

    public String getOdpD() {
        return odpD;
    }

    public void setOdpD(String odpD) {
        this.odpD = odpD;
    }

    @Override
    public String toString() {
        return "Question{" +
                "question='" + question + '\'' +
                ", odpA='" + odpA + '\'' +
                ", odbB='" + odbB + '\'' +
                ", odpC='" + odpC + '\'' +
                ", odpD='" + odpD + '\'' +
                '}';
    }
}
