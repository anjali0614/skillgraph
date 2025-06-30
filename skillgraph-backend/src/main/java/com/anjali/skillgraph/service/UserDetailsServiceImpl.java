//package com.anjali.skillgraph.service;
//
//import com.anjali.skillgraph.model.User;
//import com.anjali.skillgraph.repository.UserRepository;
//import com.anjali.skillgraph.config.UserDetailsImpl;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.core.userdetails.*;
//import org.springframework.stereotype.Service;
//
//import java.util.Optional;
//
//@Service
//public class UserDetailsServiceImpl implements UserDetailsService {
//
//    @Autowired
//    private UserRepository userRepository;
//
//    @Override
//    public UserDetails loadUserByUsername(String identifier) throws UsernameNotFoundException {
//        Optional<User> optionalUser = userRepository.findByUsername(identifier);
//
//        if (optionalUser.isEmpty()) {
//            optionalUser = userRepository.findByEmail(identifier);
//        }
//
//        return optionalUser
//                .map(UserDetailsImpl::new)
//                .orElseThrow(() -> new UsernameNotFoundException("User not found"));
//    }
//}

