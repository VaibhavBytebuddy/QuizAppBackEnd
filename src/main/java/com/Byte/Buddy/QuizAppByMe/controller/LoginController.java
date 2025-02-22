package com.Byte.Buddy.QuizAppByMe.controller;


import com.Byte.Buddy.QuizAppByMe.entity.User;
import com.Byte.Buddy.QuizAppByMe.repository.UserRepository;
import com.Byte.Buddy.QuizAppByMe.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class LoginController {


    @Autowired
    private UserRepository userRepository;


    @PostMapping("/login")
    public ResponseEntity<Map<String, String>> login(@RequestBody Map<String, String> credentials) {
        String username = credentials.get("username");
        String password = credentials.get("password");

        Optional<User> optionalUser = userRepository.findByUsername(username);

        if (optionalUser.isPresent()) {
            User user = optionalUser.get();
            if (password.equals(user.getPassword())) {
                return ResponseEntity.ok(Map.of("role", user.isAdmin() ? "admin" : "user"));
            }
        }

        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(Map.of("message", "Invalid credentials"));
    }
    }




//    @PostMapping("/login")
//    public Map<String, String> login(@RequestBody Map<String, String> credentials) {
//        String username = credentials.get("username");
//        String password = credentials.get("password");
//
//        List<User> users = userRepository.findByUsername(username);
//        for (User user : users) {
//            if (passwordEncoder.matches(password, user.getPassword())) {
//                return Map.of("role", user.isAdmin() ? "admin" : "user", "message", "Login successful");
//            }
//        }
//
//        return Map.of("message", "Invalid credentials");
//    }












