package com.exam.QuizModel;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
@Getter
@Setter

@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Quiz {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long quizid;
	private String quizTitel;
	private String quizContent;
	private boolean status =false;
	private String noOfQuestion;
	private String maxMark;
	
	@ManyToOne(fetch = FetchType.EAGER)
	private Categories category;
	
	@OneToMany(mappedBy = "quiz", fetch =FetchType.LAZY,cascade =  CascadeType.ALL )
	@JsonIgnore
	private Set<Question> questions=new HashSet<>();
	
}
