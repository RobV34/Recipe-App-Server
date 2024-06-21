package com.recipe.users;


import com.recipe.recipes.Recipe;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@CrossOrigin
public class UserController {

    @Autowired
    private UserService userService;


    @GetMapping("users")
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }


    @PostMapping("user")
    public User addUser(@RequestBody User newUser) {
        return userService.addUser(newUser);
    }


}
