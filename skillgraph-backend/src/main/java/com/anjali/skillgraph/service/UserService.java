package com.anjali.skillgraph.service;

import java.util.List;
import com.anjali.skillgraph.dto.UserDTO;
import com.anjali.skillgraph.model.User;
//import org.springframework.security.authentication.BadCredentialsException;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
import com.anjali.skillgraph.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import com.anjali.skillgraph.dto.SkillDTO;
import java.util.stream.Collectors;

import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

//    @Autowired
//    private PasswordEncoder passwordEncoder;

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
//      user.setPassword(passwordEncoder.encode(userDTO.getPassword()));
        user.setPassword(userDTO.getPassword());
        user.setLeetcodeId(userDTO.getLeetcodeId());
        user.setGfgId(userDTO.getGfgId());
        user.setCodeforcesId(userDTO.getCodeforcesId());  // encode password

        // Save user to DB
        User savedUser = userRepository.save(user);

        // Return response DTO (optional fields based on your constructor)
        return new UserDTO(savedUser.getId(), savedUser.getUsername(), savedUser.getEmail(),  savedUser.getLeetcodeId(),
                savedUser.getGfgId(),
                savedUser.getCodeforcesId());
    }

    public Optional<User> getUserById(Long id) {
        return userRepository.findById(id);
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

//        if (!passwordEncoder.matches(rawPassword, user.getPassword())) {
//            throw new RuntimeException("Invalid password");
//
//        }
            List<com.anjali.skillgraph.dto.SkillDTO> skillDTOList = user.getSkills().stream()
                    .map(skill -> new com.anjali.skillgraph.dto.SkillDTO(skill.getId(), skill.getName(), skill.getDescription(), skill.getProficiency()))
                    .collect(Collectors.toList());

            UserDTO response = new UserDTO(user.getId(), user.getFullName(), user.getEmail(), user.getLeetcodeId(), user.getGfgId(), user.getCodeforcesId());
            response.setUsername(user.getUsername());
            response.setSkills(skillDTOList);


        if (identifier == null || rawPassword == null) {
            throw new RuntimeException("Identifier or password is missing");
        }

        return user;

    }
}


