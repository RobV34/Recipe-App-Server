package com.recipe.recipes;

import com.recipe.users.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
public class RecipeManagerController {

    @Autowired
    private RecipeManagerService recipeManagerService;

    @GetMapping("recipe")
    public String getHomeMessage() {
        return "Recipe Application";
    }


    @GetMapping("recipe/{recipeName}")
    public Recipe getRecipeByName(@PathVariable String recipeName) {
        return recipeManagerService.getSingleRecipeByName(recipeName);

    }

    @GetMapping("recipes")
    public List<Recipe> getAllRecipes() {
        return recipeManagerService.getAllRecipes();
    }

    @GetMapping("recipe/userMatches")
    public List<Recipe> searchForRecipesByUserIngredients(@RequestBody User user) {
        return recipeManagerService.searchRecipeManagerByUserIngredients(user.getUserCurrentIngredients());
    }

    @PostMapping("recipe")
    public Recipe addRecipe(@RequestBody Recipe newRecipe) {
        return recipeManagerService.addRecipe(newRecipe);
    }

    @DeleteMapping("recipe/{recipeName}")
    public String deleteRecipe(@PathVariable String recipeName) {
        return recipeManagerService.deleteRecipe(recipeName);
    }
}
