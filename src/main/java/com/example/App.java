// Project Structure

// src/main/java/com/example/
//     ├── App.java          (Main application starter)
//     ├── Routes.java       (Endpoint definitions)
//     ├── controllers/
//     │   ├── UserController.java
//     │   ├── ProductController.java
//     └── services/
//         ├── UserService.java
//         └── ProductService.java

// App.java This file contains the main method and sets up the application:

package com.example;

import io.javalin.Javalin;

// This snippet creates a new Javalin instance and starts the server on port 8080. It then delegates the endpoint registration to the Routes class, where all the routes are registered for handling requests.

public class App {
    public static void main(String[] args) {
        Javalin app = Javalin.create().start(8080);

        // Delegate endpoint registration
        Routes.registerRoutes(app);
    }
}