package com.vote.app.service;
//
//import com.vote.app.model.User;
//import com.vote.app.web.dto.UserRegistration;
//
//public interface UserService {
//
//	
//	User register(UserRegistration registration);
//}

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.vote.app.model.User;
import com.vote.app.repository.UserRepo;

@Service
public class UserService {
    private final UserRepo userRepository;
    private final BCryptPasswordEncoder passwordEncoder;

    public UserService(UserRepo userRepository, BCryptPasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public User registerUser(User user) {
        // Encrypt the password before saving
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return userRepository.save(user);
    }

    public User findUserByUsername(String username) {
        return userRepository.findByUsername(username);
    }
}
