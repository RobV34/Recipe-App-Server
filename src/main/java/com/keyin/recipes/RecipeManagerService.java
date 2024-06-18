package com.keyin.recipes;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class RecipeManagerService {
    private List<Recipe> recipeArrayList = new ArrayList<>();

    public List<Recipe> getAllRecipes() {
        return recipeArrayList;
    }

    public Recipe addRecipe(Recipe recipe) {
        recipeArrayList.add(recipe);
        return recipe;
    }

    public Recipe getRecipe(String name) {
        return recipeArrayList.stream()
                .filter(recipe -> recipe.getName().equals(name))
                .findFirst()
                .orElse(null);
    }

    public void deleteRecipe(String name) {
        recipeArrayList.removeIf(recipe -> recipe.getName().equals(name));
    }

    public List<Recipe> searchRecipeManagerByUserIngredients(List<Ingredient> userIngredients) {
        return recipeArrayList.stream()
                .filter(recipe -> recipe.getIngredients().stream()
                        .allMatch(ingredient -> userIngredients.stream()
                                .anyMatch(userIngredient -> userIngredient.getName().equalsIgnoreCase(ingredient.getName()))))
                .collect(Collectors.toList());
    }
}


