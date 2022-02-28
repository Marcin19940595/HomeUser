package com.example.HomeUser.repository;

import com.example.HomeUser.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import java.util.Collection;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {
}
