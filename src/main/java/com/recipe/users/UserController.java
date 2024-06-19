package com.recipe.users;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;



@RestController
@CrossOrigin
public class UserController {

    @Autowired
    private UserService userService;


    @PostMapping("user")
    public User addUser(@RequestBody User newUser) {
        return userService.addUser(newUser);
    }


}
