package com.recipe.users;

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
}
