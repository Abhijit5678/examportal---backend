package com.exam.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.exam.QuizModel.Categories;
import com.exam.Service.CategoryService;

@RestController
@RequestMapping("/category")
@CrossOrigin
public class CategoryController {

	@Autowired
	private CategoryService categoryService;
	
	@PostMapping("/")
	ResponseEntity<?> addCategory(@RequestBody Categories category)
	{
		
		Categories categort1=categoryService.addCategory(category);
		return ResponseEntity.ok(categort1);
		
	}
	
	@GetMapping("/{id}")
	ResponseEntity<?> addCategories (@PathVariable("id") Long id)
	{
		Categories category1=categoryService.getCategoryById(id);
		
		return ResponseEntity.ok(category1);
		
	}
	
	@GetMapping("/")
	ResponseEntity<List<Categories>> getAllCategory ()
	{
		List<Categories> categoryList=categoryService.categoryList();
		return ResponseEntity.ok(categoryList);
	}
	
	@PutMapping("/updateById")
	ResponseEntity<?> updateCategories (@RequestBody Categories category)
	{
		Categories category1=categoryService.updateCategory(category);
		return ResponseEntity.ok(category1);
	}
	@DeleteMapping("/deleteById/{id}")
	ResponseEntity<String> deleteCategories(@PathVariable("id") Long id)
	{
		categoryService.deleteCategoryById(id);
		return ResponseEntity.ok("Successfully Deleted");
	}
}
