package com.vishwa.mytodobackend.todoappbackend.todo.respository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.vishwa.mytodobackend.todoappbackend.user.User;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByUsername(String username);
    Boolean existsByUsername(String username);
}
