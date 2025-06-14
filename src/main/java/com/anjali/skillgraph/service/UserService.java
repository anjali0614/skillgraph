package com.anjali.skillgraph.service;

import com.anjali.skillgraph.dto.UserDTO;
import com.anjali.skillgraph.model.User;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import com.anjali.skillgraph.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public UserDTO registerUser(UserDTO userDTO) {
        // Check for existing username
        if (userRepository.findByUsername(userDTO.getUsername()).isPresent()) {
            throw new RuntimeException("Username already exists");
        }

        // Check for existing email
        if (userRepository.findByEmail(userDTO.getEmail()).isPresent()) {
            throw new RuntimeException("Email already exists");
        }

        // Convert DTO to Entity
        User user = new User();
        user.setUsername(userDTO.getUsername());
        user.setEmail(userDTO.getEmail());
        user.setFullName(userDTO.getFullName());
        user.setPassword(passwordEncoder.encode(userDTO.getPassword()));  // encode password

        // Save user to DB
        User savedUser = userRepository.save(user);

        // Return response DTO (optional fields based on your constructor)
        return new UserDTO(savedUser.getId(), savedUser.getUsername(), savedUser.getEmail());
    }

    public Optional<User> getUserByEmail(String email) {
        return userRepository.findByEmail(email);

    }

    public User loginUser(String identifier, String rawPassword) {
        Optional<User> optionalUser;

        if (identifier.contains("@")) {
            optionalUser = userRepository.findByEmail(identifier);
        } else {
            optionalUser = userRepository.findByUsername(identifier);
        }

        if (optionalUser.isEmpty()) {
            throw new RuntimeException("User not found");
        }

        User user = optionalUser.get();

        if (!passwordEncoder.matches(rawPassword, user.getPassword())) {
            throw new RuntimeException("Invalid password");
        }
        if (identifier == null || rawPassword == null) {
            throw new RuntimeException("Identifier or password is missing");
        }

        return user;

    }
}


