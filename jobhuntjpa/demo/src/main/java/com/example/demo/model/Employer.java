package com.example.demo.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Employer {
  @Id
  private String id;

  private String name;

  private String logo_path;

  private String website;

  private String email;

  @OneToMany(mappedBy = "employer")
  private List<Job> jobs;
}
