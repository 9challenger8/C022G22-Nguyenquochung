package com.validate_form.dto;


import javax.validation.constraints.*;

public class UserDto {


    private Integer id;

    @NotEmpty(message = "Name is not empty.")
    @Size(min=5,max=45,message = "Length is from 5 to 45")
    private String firstName;

    @NotEmpty(message = "Name is not empty.")
    @Size(min=5,max=45,message = "Length is from 5 to 45")
    private String lastName;

    @Min(18)
    private Integer age;

    @Pattern(regexp = "[0-9]{10}", message = "Include ten number.")
    private String phoneNumber;

    @Email
    private String email;

    public UserDto() {
    }

    public UserDto(Integer id, String firstName, String lastName, Integer age, String phoneNumber, String email) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.phoneNumber = phoneNumber;
        this.email = email;
    }

    public UserDto(Integer id, String firstName, String lastName, String phoneNumber, String email) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.email = email;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
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

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
