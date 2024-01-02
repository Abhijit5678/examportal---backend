package com.exam.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.exam.QuizModel.Categories;
import com.exam.Repository.CategoriesRepository;

@Service
public class CategoryServiceImpl implements CategoryService{
	
	@Autowired
	private CategoriesRepository cateRepo;

	@Override
	public Categories addCategory(Categories category) {
		
		
		
		return cateRepo.save(category);
	}

	@Override
	public Categories updateCategory(Categories category) {
		
		
		
		
		
		return cateRepo.saveAndFlush(category);
	}

	@Override
	public List<Categories> categoryList() {
		
		return cateRepo.findAll();
	}

	@Override
	public Categories getCategoryById(Long cid) {
	 Categories categories=	cateRepo.findByIdCategori(cid);
		return categories;
	}

	@Override
	public void deleteCategoryById(Long cid) {
		cateRepo.deleteById(cid);
		
	}

}
