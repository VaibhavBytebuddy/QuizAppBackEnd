package com.Byte.Buddy.QuizAppByMe.service;

import com.Byte.Buddy.QuizAppByMe.entity.User;
import com.Byte.Buddy.QuizAppByMe.repository.UserRepository;
import jakarta.persistence.Column;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
@Component
public class UserService {

    @Autowired
    private UserRepository userRepository;


    public User creteUser(User user) {

        return userRepository.save(user);
    }



    public User updateUser(Long id, User user)
    {

        Optional<User> optionalUser=userRepository.findById(id);
        if(optionalUser.isPresent())
        {
            User oldUser=optionalUser.get();
            oldUser.setUsername(user.getUsername());
            oldUser.setPassword(user.getPassword());
            oldUser.setEmail(user.getEmail());
            oldUser.setAdmin(user.isAdmin());

            return userRepository.save(oldUser);

        }

        return null;


    }

    public void deleteUserById(Long id)
    {
        userRepository.deleteById(id);

    }

    public List<User> getAllUsers() {

        return userRepository.findAll();

    }


    public User getUserById(Long id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("User with ID " + id + " not found"));
    }





}
