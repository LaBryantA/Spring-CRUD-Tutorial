package com.SpringCrud.demo;

import lombok.*;

import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.Entity;

@Entity
@NoArgsConstructor
@Data public class Recipe {
	@Id @GeneratedValue
	private long id;
	private @NonNull String name;
}
