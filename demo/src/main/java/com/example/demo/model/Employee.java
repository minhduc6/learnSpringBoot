package com.example.demo.model;

import com.fasterxml.jackson.annotation.JsonIgnore;



public class Employee {
     
    @JsonIgnore
    private int id ;

    private String firstName;

    private String lastName;

    private String emailId;

    private String passportNumber;

    public Employee() {
    }

    public Employee(int id, String firstName, String lastName, String emailId, String passportNumber) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.emailId = emailId;
        this.passportNumber = passportNumber;
    }

    public Integer getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmailId() {
        return emailId;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }

    public String getPassportNumber() {
        return passportNumber;
    }

    public void setPassportNumber(String passportNumber) {
        this.passportNumber = passportNumber;
    }
    public boolean matchWithKeyWord(String keyword)
    {
        String keywordLowerCase = keyword.toLowerCase();
        return (firstName.toLowerCase().contains(keywordLowerCase) || lastName.toLowerCase().contains(keywordLowerCase)
        || emailId.toLowerCase().contains(keywordLowerCase));
    }

    


    
}
