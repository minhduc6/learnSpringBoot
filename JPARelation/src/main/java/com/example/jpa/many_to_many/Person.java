package com.example.jpa.many_to_many;


import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

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

    @ManyToMany
    @JoinTable(name = "per_add" ,joinColumns = {@JoinColumn(name = "person_id")}, inverseJoinColumns = {@JoinColumn(name = "add_id")})
    private List<Address> addresses;



}