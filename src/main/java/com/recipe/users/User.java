package com.recipe.users;

import com.recipe.recipes.Ingredient;

import java.util.List;

public class User {
    private List<Ingredient> userCurrentIngredients;

    public List<Ingredient> getUserCurrentIngredients() {
        return userCurrentIngredients;
    }

    public void setUserCurrentIngredients(List<Ingredient> userCurrentIngredients) {
        this.userCurrentIngredients = userCurrentIngredients;
    }
}
