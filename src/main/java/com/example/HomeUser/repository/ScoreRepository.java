package com.example.HomeUser.repository;

import com.example.HomeUser.model.Score;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

@Repository
@EnableJpaRepositories
public interface ScoreRepository extends JpaRepository<Score,Long> {
}
