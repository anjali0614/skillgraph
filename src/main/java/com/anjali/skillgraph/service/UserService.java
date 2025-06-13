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

    public UserDTO registerUser(User user) {
        // Encrypt the password
        user.setPassword(passwordEncoder.encode(user.getPassword()));

        // Save user to DB
        User savedUser = userRepository.save(user);

        // Convert to DTO and return
        return new UserDTO(savedUser.getId(), savedUser.getFullName(), savedUser.getEmail());
    }

    public Optional<User> getUserByEmail(String email) {
        return userRepository.findByEmail(email);

    }
    public User loginUser(String username, String rawPassword) {
        User user = userRepository.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("User not found"));

        if (passwordEncoder.matches(rawPassword, user.getPassword())) {
            return user;
        } else {
            throw new BadCredentialsException("Invalid password");
        }
    }

}


