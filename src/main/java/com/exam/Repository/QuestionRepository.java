package com.exam.Repository;

import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;

import com.exam.QuizModel.Question;
import com.exam.QuizModel.Quiz;

public interface QuestionRepository extends JpaRepository<Question, Long> {

	Set<Question> findByQuiz(Quiz quiz);

}
