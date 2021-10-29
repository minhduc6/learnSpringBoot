package com.example.employee.entity;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import java.util.Base64;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;

@Entity
public class Employee {
    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    @Column(name = "Id")
    private Integer id ;

    @NotBlank(message = "First Name không để trống")
    @Column(name = "first_name")
    private String firstName;

    @NotBlank(message = "Last Name không để trống")
    @Column(name = "last_name")
    private String lastName;

    @NotBlank(message ="Email không để trống")
    @Email(message = "Không đúng định dạng Email")
    @Column(name = "email_id")
    private String emailId;

    @Size(min = 8 , message = "Phải Nhiều Hơn 8 Ký Tự")
    @NotBlank(message = "PassPort không để trống")
    @Column(name = "passport")
    private String passportNumber;

    @Lob
    @Column(name = "Image")
    private byte[] image;

    public Employee() {
    }

    public Employee(Integer id,  String firstName,String lastName,String emailId, String passportNumber,byte[] image) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.emailId = emailId;
        this.passportNumber = passportNumber;
        this.image = image;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
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

    public byte[] getImage() {
        return image;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }

    public String generateBase64Image()
    {
       return Base64.getEncoder().encodeToString(image);
    }

    public boolean matchWithKeyWord(String keyword)
    {
        String keywordLowerCase = keyword.toLowerCase();
        return (firstName.toLowerCase().contains(keywordLowerCase) || lastName.toLowerCase().contains(keywordLowerCase)
        || emailId.toLowerCase().contains(keywordLowerCase));
    }

     
}
