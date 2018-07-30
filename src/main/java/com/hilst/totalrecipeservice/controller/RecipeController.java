package com.hilst.totalrecipeservice.controller;

import com.hilst.totalrecipeservice.exception.RecipeNotFoundException;
import com.hilst.totalrecipeservice.model.Recipe;
import com.hilst.totalrecipeservice.service.RecipeService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/recipe")
public class RecipeController {
    private RecipeService service;

    public RecipeController(RecipeService service) {
        this.service = service;
    }

    @GetMapping
    public List<Recipe> findAll() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public Recipe findById(@PathVariable("id") Long id) {
        return service.findById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Recipe create(@RequestBody Recipe recipe) {
        return service.save(recipe);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public Recipe update(@PathVariable("id") Long id, @RequestBody Recipe recipe) {
        recipe.setId(id);
        return service.update(recipe);
    }

}
