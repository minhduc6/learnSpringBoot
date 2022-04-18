//package com.example.jpa.many_to_one.joinTable;
//
//
//import lombok.Data;
//import lombok.Getter;
//import lombok.NoArgsConstructor;
//import lombok.Setter;
//
//import javax.persistence.*;
//import java.util.ArrayList;
//import java.util.List;
//
//@Data
//@Getter
//@Setter
//@NoArgsConstructor
//@Entity
//public class Address {
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Long id;
//    private String street;
//    private String zipcode;
//
//    @ManyToOne
//    @JoinTable(name = "person_address"
//            ,joinColumns = {@JoinColumn(name = "address_id")}
//            ,inverseJoinColumns = {@JoinColumn(name = "person_id")} )
//    private Person person;
//
//}
