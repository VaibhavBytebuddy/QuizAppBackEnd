package com.Byte.Buddy.QuizAppByMe.repository;

import com.Byte.Buddy.QuizAppByMe.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {

    public Optional<User> findByUsername(String username);


    boolean existsByEmail(String email);

    boolean existsByUsername(String username);
}
