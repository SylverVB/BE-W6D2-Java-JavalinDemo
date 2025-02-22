package com.example;

import io.javalin.Javalin;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class UserControllerTest {

    private Javalin app;
    
    @BeforeEach
    public void setUp() {
        // Start the Javalin app on a random available port
        app = Javalin.create().start(0);
        // Register routes
        Routes.registerRoutes(app);
    }
    
    @Test
    public void testGetAllUsers() {
        given()
            .baseUri("http://localhost:" + app.port())
        .when()
            .get("/users")
        .then()
            .statusCode(200)
            .body(equalTo("[\"John Doe\",\"Jane Smith\"]"));
    }
    
    @Test
    public void testGetUserById() {
        given()
            .baseUri("http://localhost:" + app.port())
        .when()
            .get("/users/0")
        .then()
            .statusCode(200)
            .body(equalTo("John Doe"));
    }

    @Test
    public void testCreateUser() {
        given()
            .baseUri("http://localhost:" + app.port())
            .contentType("text/plain")
            .body("Alice Wonderland")
        .when()
            .post("/users")
        .then()
            .statusCode(200)
            .body(equalTo("User created: Alice Wonderland"));
    }
}