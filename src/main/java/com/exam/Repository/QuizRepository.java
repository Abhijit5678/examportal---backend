package com.exam.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.exam.QuizModel.Quiz;

public interface QuizRepository extends JpaRepository<Quiz, Long> {

}
