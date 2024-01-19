package com.springBootProject.TodoApp.Repository;

import com.springBootProject.TodoApp.models.Todo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ToDoRepository extends JpaRepository<Todo, Long> {


}
