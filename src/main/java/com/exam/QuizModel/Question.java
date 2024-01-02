package com.exam.QuizModel;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Question {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long qesid;
	@Column(length = 5000)
	private String content;
	private String option1;
	private String option2;
	private String option3;
	private String option4;
	private String image;
	private String answer;
	@ManyToOne(fetch = FetchType.EAGER)
	private Quiz quiz;
	
	
	
}
