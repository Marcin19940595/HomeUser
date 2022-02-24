package com.example.HomeUser.repository;

import com.example.HomeUser.model.User;
import org.springframework.boot.autoconfigure.data.jpa.JpaRepositoriesAutoConfiguration;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import java.util.Collection;

@Repository
public interface UserRepository {
    void createuser(String name,String surname);
    Collection<User> getAllUsers();
    User getUser(String name);
    void removeUser(String name);
    @PostConstruct
    void build();
    void createuser(User user);
}
