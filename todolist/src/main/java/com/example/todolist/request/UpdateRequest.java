package com.example.todolist.request;


import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class UpdateRequest {
    private String title;
    private boolean status;
}
