package com.example.demo.model;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnore;


public class Employee {
     
    @JsonIgnore
    private int id ;

    @NotBlank(message = "First Name không để trống")
    private String firstName;


    @NotBlank(message = "Last Name không để trống")
    private String lastName;

    @NotBlank(message ="Email không để trống")
    @Email(message = "Không đúng định dạng Email")
    private String emailId;

    @Size(min = 8 , message = "Phải Nhiều Hơn 8 Ký Tự")
    @NotBlank(message = "PassPort không để trống")
    private String passportNumber;

    private String photo;

    public Employee() {
    }
    public Employee(int id, String firstName, String lastName, String emailId, String passportNumber,String photo) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.emailId = emailId;
        this.passportNumber = passportNumber;
        this.photo = photo;
    }

    public int getId() {
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

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public boolean matchWithKeyWord(String keyword)
    {
        String keywordLowerCase = keyword.toLowerCase();
        return (firstName.toLowerCase().contains(keywordLowerCase) || lastName.toLowerCase().contains(keywordLowerCase)
        || emailId.toLowerCase().contains(keywordLowerCase));
    }
    public String getPhotoImagePath()
    {
        return "../employee-photo/" + this.photo;
    }

    


    
}
