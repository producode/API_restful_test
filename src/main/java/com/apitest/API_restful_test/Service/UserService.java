package com.apitest.API_restful_test.Service;

import com.apitest.API_restful_test.Repository.UserRepository;
import com.apitest.API_restful_test.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User saveUser(User user) {
        return userRepository.save(user);
    }
    public User getUser() {
        return new User();
    }
}

