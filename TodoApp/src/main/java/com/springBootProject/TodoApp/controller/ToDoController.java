package com.springBootProject.TodoApp.controller;


import com.springBootProject.TodoApp.models.Todo;
import com.springBootProject.TodoApp.service.ToDoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@RestController
@RequestMapping("/todo")
public class ToDoController {
    @Autowired
    private ToDoService toDoService;

    @GetMapping
    public List<Todo> getAllTodo() {
        return toDoService.getAllToDo();
    }
    @GetMapping("/find/{id}")
    public Todo getToDoById(@PathVariable Long id){
        return toDoService.getToDoById(id);
    }
    @PostMapping("/add")
    public Todo addTodo(@RequestBody Todo todo) {
        return toDoService.addToDo(todo);
    }

//    @PostMapping("/updateStatus/{id}")
//    public String updateToDoStatus(@PathVariable Long id, RedirectAttributes redirectAttributes){
//        if (toDoService.updateToDoStatus(id)){
//            redirectAttributes.addFlashAttribute("message", "Update Success");
//            return "redirect:/todo";
//        }
//        redirectAttributes.addFlashAttribute("message", "Update Failure");
//        return "redirect:/todo";
//    }

    @PutMapping("/update/{id}")
    public Todo updateToDo(@PathVariable Long id, @RequestBody Todo todo) {
        return toDoService.updateTodo(id, todo);
    }
    @DeleteMapping("/delete/{id}")
    public String deleteToDo(@PathVariable Long id) {
        return toDoService.deleteTodo(id);
//        return "User of ID NO " + id + " has been deleted successfully";
    }
}
