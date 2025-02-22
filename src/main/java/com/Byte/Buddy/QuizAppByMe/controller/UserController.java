package com.Byte.Buddy.QuizAppByMe.controller;

import com.Byte.Buddy.QuizAppByMe.entity.User;
import com.Byte.Buddy.QuizAppByMe.repository.UserRepository;
import com.Byte.Buddy.QuizAppByMe.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("api/users")
@CrossOrigin(origins = "http://localhost:3000")


public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private UserRepository userRepository;


//    @Autowired
//    private PasswordEncoder passwordEncoder;

//    @PostMapping("/signup")
//    public Map<String, String> createUser(@RequestBody User user) {
//        String username = user.getUsername();
//        String email = user.getEmail();
//        String password = user.getPassword();
//
//        if (userRepository.existsByUsername(username)) {
//            return Map.of("message", "Username already exists");
//        }
//
//        if (userRepository.existsByEmail(email)) {
//            return Map.of("message", "Email already registered");
//        }
//
//        user.setPassword(passwordEncoder.encode(password)); // Encrypt password before saving
//        userService.creteUser(user);
//        return Map.of("message", "Signup successful");
//    }


    @PostMapping("/signup")
    public ResponseEntity<Map<String, String>> createUser(@RequestBody User user) {
        String username = user.getUsername();
        String email = user.getEmail();
        String password = user.getPassword();

        if (userRepository.existsByUsername(username)) {
            return ResponseEntity.badRequest().body(Map.of("message", "Username already exists"));
        }

        if (userRepository.existsByEmail(email)) {
            return ResponseEntity.badRequest().body(Map.of("message", "Email already registered"));
        }

        user.setPassword(password);
        userService.creteUser(user);

        return ResponseEntity.ok(Map.of("message", "Signup successful", "role", "user"));
    }


    @GetMapping("/{id}")
    public User  getUser(@PathVariable Long id)
    {
        return userService.getUserById(id);
    }
    @PutMapping("/{id}")
    public User updateUser(@PathVariable Long id,@RequestBody User user)
    {
        return userService.updateUser(id,user);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteUser(@PathVariable Long id)
    {
        userService.deleteUserById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping
    public List<User> getAllUsers()
    {
        return userService.getAllUsers();

    }

}
