package com.springBootProject.TodoApp.Repository;

import com.springBootProject.TodoApp.models.Todo;
import org.springframework.data.jpa.repository.JpaRepository;


//It is not mandatory to annotate this repository with @Repository since it extends JpaRepository
public interface ToDoRepository extends JpaRepository<Todo, Long> {


}
