package com.keyin.recipes;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class RecipeManagerService {

    private List<Recipe> recipeArrayList = new ArrayList<Recipe>();

    public List<Recipe> searchRecipeManagerByUserIngredients(List<Ingredient> userIngredients) {
        List<Recipe> matchingRecipes = new ArrayList<>();

        for (Recipe recipe : recipeArrayList) {
            if (checkIngredientInRecipe(recipe, userIngredients)) {
                matchingRecipes.add(recipe);
            }
        }

        return matchingRecipes;
    }


    public Boolean checkIngredientInRecipe(Recipe recipe, List<Ingredient> userIngredients) {
        for (Ingredient userIngredient : userIngredients) {
            boolean ingredientFound = false;
            for (Ingredient recipeIngredient : recipe.getIngredientArrayList()) {
                if (recipeIngredient.getName().equals(userIngredient.getName())) {
                    ingredientFound = true;
                    break;
                }
            }
            if (!ingredientFound) {
                return false;
            }
        }
        return true;
    }

    public Recipe addRecipe(Recipe newRecipe) {
        recipeArrayList.add(newRecipe);
        return newRecipe;
    }
}
