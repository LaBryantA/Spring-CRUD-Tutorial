package com.SpringCrud.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import java.util.stream.Stream;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringCrudDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringCrudDemoApplication.class, args);
	}
	
	@Bean
	ApplicationRunner init(RecipeRepository repository) {
		return args -> {
			Stream.of("Pizza", "Spaghetti", "Cookies", "Cake", "Fries", "Burger",
					"Fried Chicken", "Fried Egg", "Scrambled Egg").forEach(food -> {
						Recipe r = new Recipe();
						r.setName(food);
						repository.save(r);
					});
			repository.findAll().forEach(System.out::println);
		};
	}

}
