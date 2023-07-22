package com.apitest.API_restful_test.entity.DTOs;

import java.util.Date;
import java.util.List;
import java.util.UUID;

public class UserResponseDTO {
    private String name;
    private String email;
    private String password;
    private List<PhoneNumberDTO> phoneNumbers;

    private UUID id;
    private Date created;
    private Date modified;
    private Date lastLogin;
    private UUID token;
    private boolean isActive;

    public UserResponseDTO(String name, String email, String password, List<PhoneNumberDTO> phoneNumbers) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.phoneNumbers = phoneNumbers;
    }

    public UserResponseDTO(String name, String email, String password, List<PhoneNumberDTO> phoneNumbers, UUID id, Date created, Date modified, Date lastLogin, UUID token, boolean isActive) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.phoneNumbers = phoneNumbers;
        this.id = id;
        this.created = created;
        this.modified = modified;
        this.lastLogin = lastLogin;
        this.token = token;
        this.isActive = isActive;
    }

    public UserResponseDTO(UUID id, boolean isActive) {
        this.id = id;
        this.isActive = isActive;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public Date getModified() {
        return modified;
    }

    public void setModified(Date modified) {
        this.modified = modified;
    }

    public Date getLastLogin() {
        return lastLogin;
    }

    public void setLastLogin(Date lastLogin) {
        this.lastLogin = lastLogin;
    }

    public UUID getToken() {
        return token;
    }

    public void setToken(UUID token) {
        this.token = token;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
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

    public List<PhoneNumberDTO> getPhoneNumbers() {
        return phoneNumbers;
    }

    public void setPhoneNumbers(List<PhoneNumberDTO> phoneNumbers) {
        this.phoneNumbers = phoneNumbers;
    }

    @Override
    public String toString() {
        return "CreateUserDTO{" +
                "name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", phoneNumbers=" + phoneNumbers +
                '}';
    }
}

