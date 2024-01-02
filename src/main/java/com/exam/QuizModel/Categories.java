package com.exam.QuizModel;



import java.util.LinkedHashSet;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
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
public class Categories {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long cid;
	private String titel;
	private String description;
	@OneToMany(mappedBy = "category",fetch =FetchType.EAGER,cascade = CascadeType.ALL )
	@JsonIgnore
	private Set<Quiz> quizs= new LinkedHashSet<>();

}
