package com.SpringCrud.demo;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.Collection;
import java.util.stream.Collectors;

@RestController
public class RecipeController {
	private RecipeRepository r;
	
	public RecipeController(RecipeRepository repository) {
		this.r = repository;
	}
	
	@GetMapping("/foods")
	public Collection<Recipe> foodList() {
		return r.findAll().stream()
				.filter(this::theseOnes)
				.collect(Collectors.toList());
	}
	
	private boolean theseOnes(Recipe r) {
		return r.getName().equals("Pizza") ||
				r.getName().equals("Spaghetti") ||
				r.getName().equals("Fried Chicken");
		
	}
	
}
