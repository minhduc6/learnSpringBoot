package com.example.jpa.one_to_many.bidirection;

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
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String street;
    private String zipcode;

    @ManyToOne
    //@JoinColumn(name = "person_id")
    @JoinTable(name = "per_add" , joinColumns = {@JoinColumn(name = "add_id")}, inverseJoinColumns = {@JoinColumn(name = "person_id")})
    private Person person;

}
