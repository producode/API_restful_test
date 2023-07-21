package com.apitest.API_restful_test.Controller;

import com.apitest.API_restful_test.Service.UserService;
import com.apitest.API_restful_test.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {
    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    public User createUser(@RequestBody User user){
        return user;
    }

    @GetMapping
    public User getUser() {
        return userService.getUser();
    }
}

