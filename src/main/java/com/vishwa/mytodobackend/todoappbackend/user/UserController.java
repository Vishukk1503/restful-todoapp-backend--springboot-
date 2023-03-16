package com.vishwa.mytodobackend.todoappbackend.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.vishwa.mytodobackend.todoappbackend.todo.respository.UserRepository;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @PostMapping("/register")
    public ResponseEntity<String> registerUser(@RequestBody User user) {
        // Add "{noop}" prefix to the password for plain-text password storage
    	// Check if username is already taken
        if (userRepository.existsByUsername(user.getUsername())) {
            return ResponseEntity
                    .badRequest()
                    .body("Error: Username is already taken!");
        }
        user.setPassword("{noop}" + user.getPassword());

        // Save the user to the database
        userRepository.save(user);

        return ResponseEntity.ok("User registered successfully");
    }
}
