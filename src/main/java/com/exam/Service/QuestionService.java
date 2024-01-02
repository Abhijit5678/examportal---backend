package com.exam.Service;

import java.util.Set;

import com.exam.QuizModel.Question;
import com.exam.QuizModel.Quiz;

public interface QuestionService {

	public Question addQuestion(Question question);
	public Question updateQuestion(Question question);
	
	public Set<Question> getAllQuestion();
	
	public Question getQuestionById(Long qid);
	
	public Set<Question> getQustionOfQuiz(Quiz quiz);
	
	public void deleteQuestion(Long qid);
	
}
