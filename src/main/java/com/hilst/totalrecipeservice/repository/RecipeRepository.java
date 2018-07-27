package com.hilst.totalrecipeservice.repository;

import com.hilst.totalrecipeservice.model.Recipe;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RecipeRepository extends MongoRepository<Recipe, Long> {
}
