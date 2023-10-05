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

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.vote.app.model.User;
import com.vote.app.repository.UserRepo;

@Service
public class UserService {
    @Autowired
    private UserRepo userRepository;

    public User findByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    // You can add more methods for user management (e.g., user registration)
}

