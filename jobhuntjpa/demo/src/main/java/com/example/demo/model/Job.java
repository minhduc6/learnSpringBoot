package com.example.demo.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Job {
  @Id
  private String id;

  private String title;

  private String description;


  @ManyToOne
  @JoinColumn(name = "job_id")
  private Employer employer;

}
