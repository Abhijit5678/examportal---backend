package com.exam.Service;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.exam.QuizModel.Question;
import com.exam.QuizModel.Quiz;
import com.exam.Repository.QuestionRepository;
@Service
public class QuestionServiceImpl implements QuestionService {

	@Autowired
	private QuestionRepository questionrepo;
	
	@Override
	public Question addQuestion(Question question) {
		
		return questionrepo.save(question);
	}

	@Override
	public Question updateQuestion(Question question) {
		return questionrepo.save(question);
	}

	@Override
	public Set<Question> getAllQuestion() {
		return (Set<Question>) questionrepo.findAll();
	}

	@Override
	public Question getQuestionById(Long qid) {
		
		return questionrepo.findById(qid).get();
	}

	@Override
	public Set<Question> getQustionOfQuiz(Quiz quiz) {
		return questionrepo.findByQuiz(quiz);
	}

	@Override
	public void deleteQuestion(Long qid) {
		questionrepo.deleteById(qid);
		
	}

}
