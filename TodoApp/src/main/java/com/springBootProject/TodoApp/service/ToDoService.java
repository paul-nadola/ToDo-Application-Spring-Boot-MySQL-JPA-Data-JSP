package com.springBootProject.TodoApp.service;


import com.springBootProject.TodoApp.Repository.ToDoRepository;
import com.springBootProject.TodoApp.exceptions.UserNotFoundException;
import com.springBootProject.TodoApp.models.Todo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ToDoService {
    @Autowired
    private ToDoRepository toDoRepository;

    public List<Todo> getAllToDo(){
        return toDoRepository.findAll();
    }

    public Todo getToDoById(long id) {
        return toDoRepository.findById(id)
                .orElseThrow(() -> new UserNotFoundException(
                        "User of ID NO " + id + " not found"
                ));
    }
    public Todo saveToDo(Todo todo){
        return toDoRepository.save(todo);
    }
    public Todo updateTodo(Todo todo){

        Todo existingTodo = toDoRepository.findById(todo.getId())
                .orElseThrow(() -> new UserNotFoundException(
                        "User not found"
                ));
        existingTodo.setTitle(todo.getTitle());
        existingTodo.setDate(todo.getDate());
        existingTodo.setStatus(todo.getStatus());

        return toDoRepository.save(existingTodo);
    }

    public String deleteTodo(Long id) {
        toDoRepository.deleteById(id);
        return "Task by ID no" + id + "has been deleted successfully!";
    }
}
