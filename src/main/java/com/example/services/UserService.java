package com.example.services;

import java.util.List;
import java.util.ArrayList;

public class UserService {
    private static final List<String> users = new ArrayList<>();

    static {
        users.add("John Doe");
        users.add("Jane Smith");
    }

    // Make these methods static
    public static List<String> getAllUsers() {
        return users;
    }

    public static String getUserById(int id) {
        if (id < 0 || id >= users.size()) {
            return "User not found";
        }
        return users.get(id);
    }

    public static String createUser(String user) {
        users.add(user);
        return "User created: " + user;
    }
}