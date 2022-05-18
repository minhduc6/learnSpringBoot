package com.example.todolist.controller;

import com.example.todolist.model.Todo;
import com.example.todolist.request.CreateTodoRequest;
import com.example.todolist.request.UpdateRequest;
import com.example.todolist.service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/v1")
public class TodoController {

    @Autowired
    private TodoService todoService;

    @GetMapping("/todos")
    public ResponseEntity<?> getTodos(@RequestParam(required = false ,defaultValue = "") String status){
         List<Todo> todos = todoService.getTodos(status);
         return ResponseEntity.ok(todos);
    }

    @PostMapping("/todos")
    public ResponseEntity<?> createTodo(@RequestBody CreateTodoRequest createTodoRequest){
        Todo todo = todoService.createTodo(createTodoRequest);
        return ResponseEntity.ok(todo);
    }

    @PutMapping("/todos/{id}")
    public ResponseEntity<?> updateTodo(@PathVariable int id , @RequestBody UpdateRequest updateRequest){
        Todo todo = todoService.updateTodo(id,updateRequest);
        return ResponseEntity.ok(todo);
    }
    @DeleteMapping("/todos/{id}")
    public ResponseEntity<?> deleteTodo(@PathVariable int id ){
        todoService.deleteTodo(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }


}
