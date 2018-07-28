package com.hilst.totalrecipeservice.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;
import java.util.List;
import java.util.Objects;

@Document(collection = "recipes")
public class Recipe {
    @Id
    private Long id;
    private String name;
    private LocalDate createdIn;
    private boolean isVegetarian;
    private String imagePath;
    private int portionSize;
    private List<String> ingredients;
    private List<String> instructions;

    public Recipe() {}

    public Recipe(Long id, String name, LocalDate createdIn, boolean isVegetarian, String imagePath, int portionSize, List<String> ingredients, List<String> instructions) {
        this.id = id;
        this.name = name;
        this.createdIn = createdIn;
        this.isVegetarian = isVegetarian;
        this.imagePath = imagePath;
        this.portionSize = portionSize;
        this.ingredients = ingredients;
        this.instructions = instructions;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getCreatedIn() {
        return createdIn;
    }

    public void setCreatedIn(LocalDate createdIn) {
        this.createdIn = createdIn;
    }

    public boolean isVegetarian() {
        return isVegetarian;
    }

    public void setVegetarian(boolean vegetarian) {
        isVegetarian = vegetarian;
    }

    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }

    public int getPortionSize() {
        return portionSize;
    }

    public void setPortionSize(int portionSize) {
        this.portionSize = portionSize;
    }

    public List<String> getIngredients() {
        return ingredients;
    }

    public void setIngredients(List<String> ingredients) {
        this.ingredients = ingredients;
    }

    public List<String> getInstructions() {
        return instructions;
    }

    public void setInstructions(List<String> instructions) {
        this.instructions = instructions;
    }

    @Override
    public String toString() {
        return "Recipe{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", createdIn=" + createdIn +
                ", isVegetarian=" + isVegetarian +
                ", imagePath='" + imagePath + '\'' +
                ", portionSize=" + portionSize +
                ", ingredients=" + ingredients +
                ", instructions=" + instructions +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Recipe recipe = (Recipe) o;
        return isVegetarian == recipe.isVegetarian &&
                portionSize == recipe.portionSize &&
                Objects.equals(id, recipe.id) &&
                Objects.equals(name, recipe.name) &&
                Objects.equals(createdIn, recipe.createdIn) &&
                Objects.equals(imagePath, recipe.imagePath) &&
                Objects.equals(ingredients, recipe.ingredients) &&
                Objects.equals(instructions, recipe.instructions);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, createdIn, isVegetarian, imagePath, portionSize, ingredients, instructions);
    }
}
