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
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String street;
    private String zipcode;

    @ManyToMany(mappedBy = "addresses")
    private List<Person> people;

}
