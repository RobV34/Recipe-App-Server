package com.recipe.users;

import com.recipe.recipes.Recipe;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {

    private List<User> userList = new ArrayList<User>();

    public User addUser(User newUser) {
        userList.add(newUser);
        return newUser;
    }

    public List<User> getAllUsers() {
        return userList;
    }

    public User getUser(int userId) {
        return userList.stream()
                .filter(user -> user.getUserId() == userId)
                .findFirst()
                .orElse(null);
    }
}