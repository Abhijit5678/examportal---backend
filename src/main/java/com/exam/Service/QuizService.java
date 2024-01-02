package com.exam.Service;

import java.util.Set;

import com.exam.QuizModel.Quiz;

public interface QuizService {

	public Quiz addQuiz(Quiz quiz);
	public Quiz updateQuiz(Quiz quiz);
	public Set<Quiz> getQuiz();
	public Quiz getQuizone(Long qiz);
	public void deleteQuiz(Long qiz);
	
	
}
