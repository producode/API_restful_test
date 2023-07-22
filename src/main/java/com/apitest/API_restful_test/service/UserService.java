package com.apitest.API_restful_test.service;

import com.apitest.API_restful_test.entity.*;
import com.apitest.API_restful_test.entity.DTOs.PhoneNumberDTO;
import com.apitest.API_restful_test.entity.DTOs.UserRequestDTO;
import com.apitest.API_restful_test.repository.IPhoneNumberRepository;
import com.apitest.API_restful_test.repository.ITokenRepository;
import com.apitest.API_restful_test.repository.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class UserService {
    private final IUserRepository userRepository;
    private final IPhoneNumberRepository phoneNumberRepository;
    private final ITokenRepository tokenRepository;
    private final BCryptPasswordEncoder passwordEncoder;

    @Autowired
    public UserService(IUserRepository userRepository, IPhoneNumberRepository phoneNumberRepository, ITokenRepository tokenRepository) {
        this.userRepository = userRepository;
        this.phoneNumberRepository = phoneNumberRepository;
        this.tokenRepository = tokenRepository;
        this.passwordEncoder = new BCryptPasswordEncoder();
    }

    public User saveUser(UserRequestDTO userRequestDTO) {
        List<PhoneNumber> phoneNumbers = userRequestDTO.getPhones() != null ? userRequestDTO.getPhones()
                .stream()
                .map(this::convertToPhoneNumber)
                .collect(Collectors.toList())
                : new ArrayList<>();

        String encryptedPassword = passwordEncoder.encode(userRequestDTO.getPassword());

        Date currentDate = new Date();
        Token token = new Token(currentDate, calculateExpirationDate(currentDate), currentDate, currentDate, UUID.randomUUID(), true);
        token = tokenRepository.save(token);
        User user = new User(
                userRequestDTO.getName(),
                userRequestDTO.getEmail(),
                encryptedPassword,
                phoneNumbers,
                token
        );
        user = userRepository.save(user);


        return user;
    }

    private PhoneNumber convertToPhoneNumber(PhoneNumberDTO phoneNumberDTO) {
        return new PhoneNumber(phoneNumberDTO.getNumber(), phoneNumberDTO.getCityCode(), phoneNumberDTO.getCountryCode());
    }

    public static Date calculateExpirationDate(Date currentDate) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(currentDate);

        calendar.add(Calendar.DAY_OF_MONTH, 1);

        return calendar.getTime();
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }
}

