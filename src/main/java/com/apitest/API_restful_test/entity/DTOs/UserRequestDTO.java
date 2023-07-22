package com.apitest.API_restful_test.entity.DTOs;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;

import java.util.List;

public class UserRequestDTO {

    private String name;
    private String email;
    private String password;
    private List<PhoneNumberDTO> phones;

    public UserRequestDTO(String name, String email, String password, List<PhoneNumberDTO> phones) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.phones = phones;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<PhoneNumberDTO> getPhones() {
        return phones;
    }

    public void setPhones(List<PhoneNumberDTO> phones) {
        this.phones = phones;
    }

    @Override
    public String toString() {
        return "UserRequestDTO{" +
                "name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", phones=" + phones +
                '}';
    }
}
