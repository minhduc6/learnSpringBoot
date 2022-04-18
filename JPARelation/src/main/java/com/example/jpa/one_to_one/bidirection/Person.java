package com.example.jpa.one_to_one.bidirection;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Data
@Getter
@Setter
@NoArgsConstructor
//@Entity
public class Person {
     @Id
     @GeneratedValue(strategy = GenerationType.IDENTITY)
     private Long id;
     private String firstName;
     private String lastName;

     @OneToOne(mappedBy = "person")
     private Address address;

}