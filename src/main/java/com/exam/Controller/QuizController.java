package com.exam.Controller;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.exam.QuizModel.Quiz;
import com.exam.Service.QuizService;


@RestController
@RequestMapping("/quiz")
public class QuizController {

	@Autowired
	private QuizService quizService;
	@PostMapping("/")
	ResponseEntity<?> addQuiz (@RequestBody Quiz quiz)
	{
		Quiz quiz1=quizService.addQuiz(quiz);
		return ResponseEntity.ok(quiz1);
		
		
	}
	
	@PutMapping("/updateById")
	ResponseEntity<?> updateQuiz(@RequestBody Quiz quiz)
	{
		Quiz quiz2=quizService.updateQuiz(quiz);
		return ResponseEntity.ok(quiz2);
	}
	
	
	@GetMapping("/")
	ResponseEntity<Set<?>> getAllQuizs ()
	{
		Set<Quiz> listQuiz=quizService.getQuiz();
		return ResponseEntity.ok(listQuiz);
	}
	
	@GetMapping("/{qid}")
	ResponseEntity<Quiz> getaQuiz (@PathVariable("qid") Long qid)
	{
		Quiz quiz=quizService.getQuizone(qid);
		return ResponseEntity.ok(quiz);
	}
	
	@DeleteMapping("/deleteById/{qid}")
	ResponseEntity<String> deleteQuiz(@PathVariable("qid") Long qid)
	{
		quizService.deleteQuiz(qid);
		return ResponseEntity.ok("Successfully Deleted");
		
	}
}
