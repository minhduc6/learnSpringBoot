package com.example.todolist.model;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Todo {
    private int id;
    private String title;
    private boolean status;
}
