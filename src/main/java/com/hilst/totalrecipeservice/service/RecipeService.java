package com.hilst.totalrecipeservice.service;

import com.hilst.totalrecipeservice.exception.RecipeNotFoundException;
import com.hilst.totalrecipeservice.model.Recipe;
import com.hilst.totalrecipeservice.repository.RecipeRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RecipeService {
    private RecipeRepository repository;


    public RecipeService(RecipeRepository repository) {
        this.repository = repository;
    }

    public List<Recipe> findAll() {
        return repository.findAll();
    }

    public Recipe findOne(Long id) {
        return repository.findById(id).orElseThrow(RecipeNotFoundException::new);
    }

    public Recipe save(Recipe recipe) {
        return repository.save(recipe);
    }

    public Recipe update(Recipe recipe) {
        repository.findById(recipe.getId()).orElseThrow(RecipeNotFoundException::new);
        return repository.save(recipe);
    }
}
