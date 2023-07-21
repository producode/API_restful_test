package com.apitest.API_restful_test.Service;

//import com.apitest.API_restful_test.Repository.UserRepository;
import com.apitest.API_restful_test.Entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    public User saveUser(User user) {
        return user;
    }
    public User getUser() {
        return new User();
    }
}

