package com.example.controllers;

import com.example.services.UserService;
import io.javalin.http.Context;

public class UserController {
    public static void getAllUsers(Context ctx) {
        // Logic to fetch users
        ctx.json(UserService.getAllUsers()); // Call the static method directly
    }

    public static void getUserById(Context ctx) {
        int id = Integer.parseInt(ctx.pathParam("id"));
        ctx.result(UserService.getUserById(id));
    }

    public static void createUser(Context ctx) {
        // Logic to create a user
        String userData = ctx.body();
        ctx.result(UserService.createUser(userData));
    }
}

// A Controller Class is a design pattern used in web development to separate the logic that handles incoming requests from other parts of your application, like route definitions, services, and database operations. This separation promotes cleaner code, easier maintenance, and better scalability.

// Here’s a more detailed explanation to clarify:

// Why Use Controller Classes Instead of Handling Everything in Routes?

// 1. Separation of Concerns

// • Routes should only define the endpoints and delegate request handling to controllers.
// • Controllers are responsible for the business logic associated with the endpoints.

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

// // As the application grows, Routes becomes cluttered with both endpoint definitions and logic.

// // Example With Controllers:

// // Logic is moved to UserController:

// package com.example.controllers;

// import io.javalin.http.Context;

// public class UserController {
//     public static void getAllUsers(Context ctx) {
//         // Logic to fetch users
//         ctx.result("List of users");
//     }

//     public static void createUser(Context ctx) {
//         // Logic to create a user
//         String userData = ctx.body();
//         ctx.result("User created: " + userData);
//     }
// }

// // In Routes, you only register endpoints:

// package com.example;

// import com.example.controllers.UserController;
// import io.javalin.Javalin;

// public class Routes {
//     public static void registerRoutes(Javalin app) {
//         app.get("/users", UserController::getAllUsers);
//         app.post("/users", UserController::createUser);
//     }
// }

// 2. Improved Code Organization

// • Controllers help keep your code modular by grouping related logic in one place.
// • Example: All user-related logic goes into UserController. All product-related logic goes into ProductController.

// 3. Reusability

// Controllers allow you to reuse logic across different parts of your application. For instance, if multiple routes need to fetch user data, you can implement this in a controller method and reuse it.

// 4. Scalability

// When your application grows to have dozens or hundreds of endpoints, keeping everything in Routes makes it unwieldy. Controllers help by breaking the code into smaller, more manageable pieces.

// 5. Testing and Debugging

// • Controllers make it easier to test the logic of individual endpoints.
// • You can test a method like UserController.getAllUsers() independently, without relying on the full application setup.

// When Might You Not Use Controllers?

// • For small applications with only a few endpoints, you can handle logic directly in Routes for simplicity.
// • For quick prototypes or experiments where you don’t need long-term maintainability.