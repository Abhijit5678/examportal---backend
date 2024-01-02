package com.exam.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.exam.QuizModel.Categories;

public interface CategoriesRepository extends JpaRepository<Categories, Long> {
	@Query(nativeQuery=true ,value = "SELECT * FROM categories where cid=:cid")
	Categories findByIdCategori(Long cid);

}
