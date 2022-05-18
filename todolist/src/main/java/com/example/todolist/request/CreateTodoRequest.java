package com.example.todolist.request;


import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class CreateTodoRequest {
    private String title;
}
