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

    @GetMapping("recipe/userMatches")
    public List<Recipe> searchForRecipesByUserIngredients(@RequestBody User user) {
        return recipeManagerService.searchRecipeManagerByUserIngredients(user.getUserCurrentIngredients());
    }

    @PostMapping("recipe")
    public Recipe addRecipe(@RequestBody Recipe newRecipe) {
        return recipeManagerService.addRecipe(newRecipe);
    }
}
