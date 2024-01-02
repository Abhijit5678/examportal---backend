package com.exam.Service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.exam.QuizModel.Quiz;
import com.exam.Repository.QuizRepository;
@Service
public class QuizServiceImpl implements QuizService {
	@Autowired
	private QuizRepository quizrepo;
	
	@Override
	public Quiz addQuiz(Quiz quiz) {
		return quizrepo.save(quiz);
	}

	@Override
	public Quiz updateQuiz(Quiz quiz) {
		return quizrepo.save(quiz);
	}

	@Override
	public Set<Quiz> getQuiz() {
		List<Quiz> arrayList = new ArrayList<>();
		arrayList=quizrepo.findAll();
		Set<Quiz> set = new HashSet<>(arrayList);
		return set;
	}

	@Override
	public Quiz getQuizone(Long qiz) {
		return quizrepo.findById(qiz).get();
	}

	@Override
	public void deleteQuiz(Long qiz) {
		quizrepo.deleteById(qiz);

	}

}
