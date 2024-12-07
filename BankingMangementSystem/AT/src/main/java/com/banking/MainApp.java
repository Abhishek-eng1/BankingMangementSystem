package com.banking;

import com.banking.dao.UserDAO;
import com.banking.model.User;

public class MainApp {
    public static void main(String[] args) {
        UserDAO userDAO = new UserDAO();

        // Example: Add a user
        try {
            User user = new User("john_doe", "password123", 1000.0);
            userDAO.addUser(user);
            System.out.println("User added successfully!");

            // Fetch user details
            User fetchedUser = userDAO.getUser("john_doe");
            if (fetchedUser != null) {
                System.out.println("Welcome, " + fetchedUser.getUsername());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
