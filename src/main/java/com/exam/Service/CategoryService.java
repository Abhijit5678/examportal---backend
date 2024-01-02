package com.exam.Service;

import java.util.List;

import com.exam.QuizModel.Categories;

public interface CategoryService {

	public Categories addCategory(Categories category);
	
	public Categories updateCategory(Categories category);
	
	public List<Categories> categoryList();
	
	public Categories getCategoryById(Long cid);
	
	public void deleteCategoryById(Long cid );
}
