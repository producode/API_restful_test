package com.apitest.API_restful_test.Service;

import com.apitest.API_restful_test.Repository.IPhoneNumberRepository;
import com.apitest.API_restful_test.Repository.IUserRepository;
import com.apitest.API_restful_test.Entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    private final IUserRepository userRepository;
    private final IPhoneNumberRepository phoneNumberRepository;

    @Autowired
    public UserService(IUserRepository userRepository, IPhoneNumberRepository phoneNumberRepository) {
        this.userRepository = userRepository;
        this.phoneNumberRepository = phoneNumberRepository;
    }

    public User saveUser(User user) {
        return userRepository.save(user);
    }
}

