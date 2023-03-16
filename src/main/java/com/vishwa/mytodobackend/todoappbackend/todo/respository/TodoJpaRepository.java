package com.vishwa.mytodobackend.todoappbackend.todo.respository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vishwa.mytodobackend.todoappbackend.todo.Todo;

public interface TodoJpaRepository extends JpaRepository<Todo, Integer> {
	

	List<Todo> findByUsername(String username);

}
