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
    public ResponseEntity<String> registerUser(@RequestBody @Valid UserDTO userDTO) {
        return ResponseEntity.ok("User registered successfully");
    }

    @PostMapping("/login")
    public ResponseEntity<?> loginUser(@RequestBody LoginDTO loginDTO) {
        try {
            // Extracting username and password from DTO
            String username = loginDTO.getUsername();
            String password = loginDTO.getPassword();

            User user = userService.loginUser(username, password);

            return ResponseEntity.ok("Login successful: " + user.getusername());
        } catch (Exception e) {
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
