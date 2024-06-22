package com.recipe.users;

import com.recipe.recipes.Ingredient;

import java.util.List;

public class User {
    private int userId;
    private List<Ingredient> userCurrentIngredients;

    public User() {

    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public List<Ingredient> getUserCurrentIngredients() {
        return userCurrentIngredients;
    }

    public void setUserCurrentIngredients(List<Ingredient> userCurrentIngredients) {
        this.userCurrentIngredients = userCurrentIngredients;
    }
}
