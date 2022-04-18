//package com.example.jpa.one_to_many.unidirection.joinTable;
//
//
//import lombok.Data;
//import lombok.Getter;
//import lombok.NoArgsConstructor;
//import lombok.Setter;
//
//import javax.persistence.*;
//import java.util.List;
//
//@Data
//@Getter
//@Setter
//@NoArgsConstructor
//@Entity
//public class Person {
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Long id;
//    private String firstName;
//    private String lastName;
//
//    @OneToMany
//    @JoinTable(name = "per_add", joinColumns = {@JoinColumn(name = "person_id")}, inverseJoinColumns = {@JoinColumn(name = "add_id")})
//    //@JoinColumn(name = "person_id")
//    private List<Address> addresses;
//}
