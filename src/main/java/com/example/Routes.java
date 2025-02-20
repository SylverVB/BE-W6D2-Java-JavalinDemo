package com.example;

import com.example.controllers.UserController;
import io.javalin.Javalin;

// Does UserController Implement a Functional Interface?

// • No, UserController is a class, not an interface.
// • The methods getAllUsers, getUserById and createUser are static methods inside the UserController class.
// • These static methods are not part of a functional interface. They are simply invoked using a method reference.

public class Routes {
    public static void registerRoutes(Javalin app) {
        // the line app.get() uses a method reference (UserController::getAllUsers) 
        // to pass the static method as a callback. The Javalin framework
        // expects a method that matches the functional interface of Handler.
        app.get("/users", UserController::getAllUsers);
        app.get("/users/{id}", UserController::getUserById);
        app.post("/users", UserController::createUser);
        // Add more routes here
    }
}

// Using Lambda

// package com.example;

// import io.javalin.Javalin;

// public class Routes {
//     public static void registerRoutes(Javalin app) {
//         app.get("/", ctx -> ctx.result("Hello World"));
//         app.get("/users", ctx -> ctx.result("List of users"));
//         // Add more routes here
//     }
// }

// Example Without Controllers:

// All logic is in Routes:

// package com.example;

// import io.javalin.Javalin;

// public class Routes {
//     public static void registerRoutes(Javalin app) {
//         app.get("/users", ctx -> {
//             // Logic to fetch users
//             ctx.result("List of users");
//         });

//         app.post("/users", ctx -> {
//             // Logic to create a user
//             String userData = ctx.body();
//             ctx.result("User created: " + userData);
//         });
//     }
// }

// As the application grows, Routes becomes cluttered with both endpoint definitions and logic, so it should only be used without Controller Class for small applications with only a few endpoints or quick prototypes or experiments where you don’t need long-term maintainability.