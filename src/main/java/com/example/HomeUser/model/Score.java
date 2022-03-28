package com.example.HomeUser.model;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Component
@Entity
@Table(name = "score")
public class Score {
    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String scoreid;
    @ManyToMany
    @JoinTable(
            name = "UserScore",
            joinColumns = @JoinColumn(name = "scoreid"),
            inverseJoinColumns = @JoinColumn(name = "userid")
    )
    private Set <User> users = new HashSet<>();

    private String username;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Score() {
    }

    public Score(String scoreid, Set<User> users, String username) {
        this.scoreid = scoreid;
        this.users = users;
        this.username = username;
    }

    public String getScoreid() {
        return scoreid;
    }

    public void setScoreid(String scoreid) {
        this.scoreid = scoreid;
    }

    public Set<User> getUsers() {
        return users;
    }

    public void setUsers(Set<User> users) {
        this.users = users;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public String toString() {
        return "Score{" +
                "id=" + id +
                ", scoreid='" + scoreid + '\'' +
                ", users=" + users +
                ", username='" + username + '\'' +
                '}';
    }
}
