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
            if (checkIngredientInUserList(recipe, userIngredients)) {
                matchingRecipes.add(recipe);
            }
        }

        return matchingRecipes;
    }


    public Boolean checkIngredientInUserList(Recipe recipe, List<Ingredient> userIngredients) {
        for (Ingredient recipeIngredient : recipe.getIngredientArrayList()) {
            if (!userIngredients.contains(recipeIngredient)) {
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
