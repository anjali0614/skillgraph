package com.anjali.skillgraph.controller;

import com.anjali.skillgraph.dto.LoginDTO;
import com.anjali.skillgraph.dto.UserDTO;
import com.anjali.skillgraph.model.User;
import com.anjali.skillgraph.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/register")
//    public ResponseEntity<User> registerUser(@RequestBody User user) {
//        User registeredUser = userService.register(user);
//        return new ResponseEntity<>(registeredUser, HttpStatus.CREATED);
//    }
    public ResponseEntity<String> registerUser(@RequestBody UserDTO userDTO) {
        userService.registerUser(userDTO);
        return ResponseEntity.ok("User registered successfully");
    }

    @PostMapping("/login")
    public ResponseEntity<?> loginUser(@RequestBody LoginDTO loginDTO) {
        try {
            // Extracting username and password from DTO
            String identifier = loginDTO.getIdentifier();
            String password = loginDTO.getPassword();

            User user = userService.loginUser(loginDTO.getIdentifier(), loginDTO.getPassword());

            return ResponseEntity.ok("Login successful: " + user.getFullName());
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(e.getMessage());
        }
    }


//    @GetMapping("/email/{email}")
//    public ResponseEntity<User> getUserByEmail(@PathVariable String email) {
//        Optional<User> user = userService.getUserByEmail(email);
//        return user.map(ResponseEntity::ok)
//                .orElseGet(() -> ResponseEntity.notFound().build());
//    }

    @GetMapping("/test")
    public String testAPI() {
        return "API is working!";
    }

}
