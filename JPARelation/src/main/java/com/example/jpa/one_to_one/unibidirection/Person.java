package com.example.jpa.one_to_one.unibidirection;

import com.example.jpa.one_to_one.unibidirection.Address;
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

     @OneToOne
     @JoinColumn(name = "add_id")
     private Address address;

}