package com.example.todolist.service;

import com.example.todolist.model.Todo;
import com.example.todolist.request.CreateTodoRequest;
import com.example.todolist.request.UpdateRequest;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

@Service
public class TodoService {
    private List<Todo> todos = new ArrayList<>();

    public TodoService() {
        Random rd = new Random();
        todos.add(new Todo(rd.nextInt(100), "Game",false));
        todos.add(new Todo(rd.nextInt(100), "Study",true));
        todos.add(new Todo(rd.nextInt(100), "Football",true));

    }
    public  List<Todo> getTodos(String status){
        // variable: Một biến để kiểm tra.
        switch (status) {
            case  "true":
                // Làm gì đó tại đây ...
                return todos.stream().filter(Todo::isStatus).collect(Collectors.toList());
            case  "false":
                return todos.stream().filter(todo -> !todo.isStatus()).collect(Collectors.toList());
                // Làm gì đó tại đây ...
            default: return  todos;
                // Làm gì đó tại đây ...
        }
    }

    public Todo createTodo(CreateTodoRequest createTodoRequest){
        Todo todo = new Todo();
        Random rd = new Random();
        todo.setId(rd.nextInt(100));
        todo.setTitle(createTodoRequest.getTitle());
        todo.setStatus(false);
        todos.add(todo);
        return  todo;
    }

    public Todo updateTodo(int id, UpdateRequest updateRequest) {
        for (int i = 0; i < todos.size(); i++) {
              if(todos.get(i).getId()  == id){
                  todos.get(i).setTitle(updateRequest.getTitle());
                  todos.get(i).setStatus(updateRequest.isStatus());
                  return todos.get(i);
              }
        }
        return null;
    }

    public void deleteTodo(int id) {
        for (int i = 0; i < todos.size(); i++) {
            if(todos.get(i).getId()  == id){
                todos.remove(i);
            }
        }
    }
}
