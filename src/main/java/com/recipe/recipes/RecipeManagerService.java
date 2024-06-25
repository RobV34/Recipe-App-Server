package com.recipe.recipes;

import com.recipe.users.User;
import com.recipe.users.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class RecipeManagerService {
    private List<Recipe> recipeArrayList = new ArrayList<>();

    @Autowired
    private UserService userService;

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

    public String deleteRecipe(String name) {
        recipeArrayList.removeIf(recipe -> recipe.getName().equals(name));
        return "Recipe removed from list";
    }

    public List<Recipe> searchRecipeManagerByUserIngredients(int userId) {

        User selectedUser = userService.getUser(userId);

        List<Ingredient> userIngredients = selectedUser.getUserCurrentIngredients();
        return recipeArrayList.stream()
                .filter(recipe -> recipe.getIngredients().stream()
                        .allMatch(ingredient -> userIngredients.stream()
                                .anyMatch(userIngredient -> userIngredient.getName().equalsIgnoreCase(ingredient.getName()))))
                .collect(Collectors.toList());
    }


    public Recipe getSingleRecipeByName(String recipeName) {

        for (Recipe recipe : recipeArrayList) {
            if (recipe.getName().equalsIgnoreCase(recipeName)) {
                return recipe;
            }
        }
        return null;
    }

    public List<Recipe> searchRecipeManagerForNoCommonAllergens() {

        List<Recipe> listOfRecipesNoAllergens = new ArrayList<>();
        listOfRecipesNoAllergens = recipeArrayList.stream()
                .filter(recipe -> recipe.getIngredients().stream()
                        .allMatch(ingredient -> ingredient.getCommonAllergen() == false))
                .collect(Collectors.toList());

        System.out.println(listOfRecipesNoAllergens);
        return  listOfRecipesNoAllergens;
    }
}

