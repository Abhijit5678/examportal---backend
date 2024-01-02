package com.exam.Controller;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
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

import com.exam.QuizModel.Question;
import com.exam.QuizModel.Quiz;
import com.exam.Service.QuestionService;
import com.exam.Service.QuizService;

@RestController
@RequestMapping("/question")
public class QuestionController {
	@Autowired
	private QuestionService questionservice;
	
	@Autowired
	private QuizService quizservice;
	
	@PostMapping("/")
	ResponseEntity<?> addQuestion (@RequestBody Question question)
	{
		Question question1=questionservice.addQuestion(question);
		
		return ResponseEntity.ok(question1);
		
	}
	
	@GetMapping("/")
	ResponseEntity<?> getAllQuestion()
	{
		
		Set<Question> listQuestion=questionservice.getAllQuestion();
		return ResponseEntity.ok(listQuestion);
		
	}
	
	@GetMapping("/{qesid}")
	ResponseEntity<?> getQuestionById(@PathVariable("qesid") Long qesid )
	{
		Question question=questionservice.getQuestionById(qesid);
		
		return ResponseEntity.ok(question);
	}
	
	@PutMapping("/updateQuestion")
	ResponseEntity<?> updateQuestion(@RequestBody Question question)
	
	{
		Question question1=questionservice.updateQuestion(question);
		
		return ResponseEntity.ok(question1);
		
	} 
	@DeleteMapping("/deleteQuestion/{queid}")
	ResponseEntity<?> deleteQuestion(@PathVariable("qesid") Long qesid)
	{
		questionservice.deleteQuestion(qesid);
		
		return ResponseEntity.ok("Deleted Question Successfully");
		
	}
	
	@GetMapping("/quiz/{qid}")
	public ResponseEntity<?> getQuestionOfQuiz(@PathVariable("qid") Long qid)
	{
		Quiz quiz= quizservice.getQuizone(qid);
		Set<Question> questions=quiz.getQuestions();
		List list=new ArrayList<>(questions);
		if (list.size()>Integer.parseInt(quiz.getNoOfQuestion())) {
			{
				list=list.subList(0, Integer.parseInt(quiz.getNoOfQuestion()+1));
			}
		}
		Collections.shuffle(list);
		return ResponseEntity.ok(list);
	}
	
	
}
